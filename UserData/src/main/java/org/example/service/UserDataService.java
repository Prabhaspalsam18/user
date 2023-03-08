package org.example.service;

import org.example.dto.UserDataRequest;
import org.example.dto.UserDataResponse;
import org.example.model.UserDataMongo;
import org.example.model.UserDataPostgres;
import org.example.repositry.UserDataMongoRepositry;
import org.example.repositry.UserDataPostgresRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UserDataService  {
    @Autowired
    UserDataMongoRepositry userDataMongoRepositry;
    @Autowired
    UserDataPostgresRepositry userDataPostgresRepositry;
    public UserDataResponse createUserData(UserDataRequest userDataRequest){
        UserDataMongo userDataMongo = UserDataMongo.builder()
                .id(userDataRequest.getId())
                .first_name(userDataRequest.getFirst_name())
                .last_name(userDataRequest.getLast_name())
                .email(userDataRequest.getEmail())
                .mobile_number(userDataRequest.getMobile_number())
                .address(userDataRequest.getAddress())
                .build();
        UserDataPostgres userDataPostgres=new UserDataPostgres(userDataRequest.getId(),userDataRequest.getFirst_name(),userDataRequest.getLast_name(),userDataRequest.getEmail(),userDataRequest.getMobile_number(),userDataRequest.getAddress());
/*
     userDataMongoRepositry.save(userDataMongo);
      userDataPostgresRepositry.save(userDataPostgres);
*/
        Thread mongoRunnable=new Thread(() ->{userDataMongoRepositry.save(userDataMongo);});
        Thread postgresRunnable=new Thread(() -> {userDataPostgresRepositry.save(userDataPostgres);});
        mongoRunnable.start();
        postgresRunnable.start();
        UserDataResponse userDataResponse=new UserDataResponse(userDataRequest.getId(),userDataRequest.getFirst_name(),userDataRequest.getLast_name(),userDataRequest.getEmail(),userDataRequest.getMobile_number(),userDataRequest.getAddress());
        return userDataResponse;
    }
    public List<UserDataMongo> getAllUserData(){
        return userDataMongoRepositry.findAll();
    }
    public List<UserDataResponse> getUserData(String id){
        Iterable<UserDataMongo> filterUserData=userDataMongoRepositry.findAllById(Arrays.asList(id));
        List<UserDataResponse> userDataResponses=new ArrayList<>();
        filterUserData.forEach((userDataMongo)-> {
            UserDataResponse userDataResponse=new UserDataResponse(userDataMongo.getId(),userDataMongo.getFirst_name(),userDataMongo.getLast_name(),userDataMongo.getEmail(),userDataMongo.getMobile_number(),userDataMongo.getAddress());
            userDataResponses.add(userDataResponse);
        });
        return userDataResponses;
    }
    public String updateUserData(UserDataRequest userDataRequest){
        Iterable<UserDataMongo> updateUserData=userDataMongoRepositry.findAllById(Arrays.asList(userDataRequest.getId()));
        Iterable<UserDataPostgres> updatePostgreauserData=userDataPostgresRepositry.findAllById(Arrays.asList(userDataRequest.getId()));
        updateUserData.forEach((userDataMongo)-> {
            userDataMongo.setFirst_name(userDataRequest.getFirst_name());
            userDataMongo.setLast_name(userDataRequest.getLast_name());
            userDataMongo.setEmail(userDataRequest.getEmail());
            userDataMongo.setMobile_number(userDataRequest.getMobile_number());
            userDataMongo.setAddress(userDataRequest.getAddress());
            userDataMongoRepositry.save(userDataMongo);
        });
        updatePostgreauserData.forEach((userDataPostgres)-> {
            userDataPostgres.setFirst_name(userDataRequest.getFirst_name());
            userDataPostgres.setLast_name(userDataRequest.getLast_name());
            userDataPostgres.setEmail(userDataRequest.getEmail());
            userDataPostgres.setMobile_number(userDataRequest.getMobile_number());
            userDataPostgres.setAddress(userDataRequest.getAddress());
            userDataPostgresRepositry.save(userDataPostgres);
        });
        return "Successfully updated 1 user";
    }
    public String deleteAllUserData(){
        userDataMongoRepositry.deleteAll();
        userDataPostgresRepositry.deleteAll();

        return "All users deleted successfully";
    }
    public String deleteUserData(String id) {
        userDataMongoRepositry.deleteAllById(Arrays.asList(id));
        userDataPostgresRepositry.deleteAllById(Arrays.asList(id));
        return "Successfully deleted one user";
    }
}

