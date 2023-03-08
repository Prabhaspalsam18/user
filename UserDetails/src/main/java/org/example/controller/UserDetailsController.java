package org.example.controller;

import org.example.dto.UserDetailsRequest;
import org.example.dto.UserDetailsResponse;
import org.example.model.UserDetails;
import org.example.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/userdetails")
@RestController
public class UserDetailsController {
    @Autowired
    UserDetailsService userDetailsService;
    @PostMapping
    public UserDetailsResponse createUserId(@RequestBody UserDetailsRequest userDetailsRequest){
        if (!isValidEmail(userDetailsRequest.getEmail())) {
            throw new IllegalArgumentException("Invalid email format");
        }

        return userDetailsService.createUserId(userDetailsRequest);
    }
    private boolean isValidEmail(String email){
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return email.matches(regex);
    }
    @GetMapping
    public List<UserDetailsResponse> getAllUserDetails(){
        return userDetailsService.getAllUserDetails();
    }
    @GetMapping("/{id}")
    public List<UserDetailsResponse> getUserDetails(@PathVariable long id){
        return userDetailsService.getUserDetails(id);
    }
    @DeleteMapping
    public String deleteAllUserDetails(){
        return userDetailsService.deleteAllUserDetails();
    }
    @PutMapping
    public String updateUserData(@RequestBody UserDetailsRequest userDetailsRequest){
        if (!isValidEmail(userDetailsRequest.getEmail())) {
            throw new IllegalArgumentException("Invalid email format");
        }
        return userDetailsService.updateUserData(userDetailsRequest);
    }
    @DeleteMapping("/{id}")
    public String deleteUserDetails(@PathVariable long id){
        return userDetailsService.deleteUserDetails(id);
    }
}
