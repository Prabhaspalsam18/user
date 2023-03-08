package org.example.service;

import org.example.dto.UserDetailsRequest;
import org.example.dto.UserDetailsResponse;
import org.example.model.UserDetails;
import org.example.repositry.UserDetailsRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserDetailsService {
    @Autowired
    UserDetailsRepositry userDetailsRepositry;

    public UserDetailsResponse createUserId(UserDetailsRequest userDetailsResquest){
        UserDetails userDetails=new UserDetails(userDetailsResquest.getId(),userDetailsResquest.getZip_code(),userDetailsResquest.getEmail());
        userDetailsRepositry.save(userDetails);
        UserDetailsResponse userDetailsResponse=new UserDetailsResponse(userDetails.getId(),userDetails.getZip_code(),userDetails.getEmail());
        return userDetailsResponse;
    }
    public List<UserDetailsResponse> getAllUserDetails(){
        Iterable<UserDetails> getUserDetails=userDetailsRepositry.findAll();
        List<UserDetailsResponse> userDetailsResponses=new ArrayList<>();
        for (UserDetails userDetails:getUserDetails) {
            UserDetailsResponse userDetailsResponse= new UserDetailsResponse(userDetails.getId(),userDetails.getZip_code(),userDetails.getEmail());
            userDetailsResponses.add(userDetailsResponse);
        }
        return userDetailsResponses;
    }
    public List<UserDetailsResponse> getUserDetails(long id){
        Iterable<UserDetails> getUserDetails=userDetailsRepositry.findAllById(Arrays.asList(id));
        List<UserDetailsResponse> userDetailsResponses=new ArrayList<>();
        for (UserDetails userDetails:getUserDetails) {
            UserDetailsResponse userDetailsResponse= new UserDetailsResponse(userDetails.getId(),userDetails.getZip_code(),userDetails.getEmail());
            userDetailsResponses.add(userDetailsResponse);
        }
        return userDetailsResponses;
    }
    public String updateUserData(UserDetailsRequest userDetailsRequest){
        Iterable<UserDetails> updateUserDetails=userDetailsRepositry.findAllById(Arrays.asList(userDetailsRequest.getId()));
        for (UserDetails userDetails:updateUserDetails) {
            userDetails.setEmail(userDetailsRequest.getEmail());
            userDetails.setZip_code(userDetailsRequest.getZip_code());
            userDetailsRepositry.save(userDetails);
        }
        return "Successfully updated user details";
    }
    public String deleteAllUserDetails(){
        userDetailsRepositry.deleteAll();
        return "All Users are Deleted";
    }
    public String deleteUserDetails(long id){
        userDetailsRepositry.deleteAllById(Arrays.asList(id));
        return "Successfully deleted 1 user details";
    }

}
