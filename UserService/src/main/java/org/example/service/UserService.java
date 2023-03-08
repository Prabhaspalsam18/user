package org.example.service;

import org.example.dto.UserRequest;
import org.example.dto.UserResponse;
import org.example.model.User;
import org.example.repositry.UserRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepositry userRepositry;

    public UserResponse createUserData(UserRequest userRequest){
        User user=new User(userRequest.getUser_id(),userRequest.getName(),userRequest.getMobile_number());
        userRepositry.save(user);
        UserResponse userResponse=new UserResponse(userRequest.getUser_id(),userRequest.getName(),userRequest.getMobile_number());
        return userResponse;
    }
    public List<User> getAllUserData(){
//        Iterable<User> updateUser=userRepositry.findAll();
//        List<UserResponse> userResponses=new ArrayList<>();
//        for (User user:updateUser) {
//            UserResponse userResponse = new UserResponse(user.getUser_id(),user.getName(), user.getMobile_number());
//            userResponses.add(userResponse);
//        }
//        return userResponses;
        return userRepositry.findAll();
    }

    public List<UserResponse> getFilterUserData(String id){
        Iterable<User> filterUserData=userRepositry.findAllById(Arrays.asList(id));
        List<UserResponse> userResponses=new ArrayList<>();
        for (User user:filterUserData) {
            UserResponse userResponse=new UserResponse(user.getUser_id(),user.getName(), user.getMobile_number());
            userResponses.add(userResponse);
        }
        return userResponses;

    }
    public String deleteUser(String id){
        userRepositry.deleteAllById(Collections.singletonList(id));
        return "1 User has Deleted Successfully";
    }
    public String deleteAllUsers(){
        userRepositry.deleteAll();
        return "Successfully deleted all users";
    }
    public String updateUser(UserRequest userRequest){
        Iterable<User> updateUserData=userRepositry.findAllById(Collections.singletonList(userRequest.getUser_id()));
        for (User user:updateUserData) {
           user.setMobile_number(userRequest.getMobile_number());
           user.setName(userRequest.getName());
           userRepositry.save(user);
        }
        return "User Successfully Updated";
    }
}
