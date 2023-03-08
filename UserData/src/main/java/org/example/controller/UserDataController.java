package org.example.controller;

import org.example.dto.UserDataRequest;
import org.example.dto.UserDataResponse;
import org.example.model.UserDataMongo;
import org.example.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.HealthComponent;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthEndpoint;

import java.util.List;

@RestController
@RequestMapping("/userdata")
public class UserDataController {
    @Autowired
    UserDataService userDataService;
    @PostMapping
    public UserDataResponse createUserData(@RequestBody UserDataRequest userDataRequest){
        if (!isValidEmail(userDataRequest.getEmail())) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (!isValidMobileNumber(userDataRequest.getMobile_number())) {
            throw new IllegalArgumentException("Invalid mobile number format");
        }
        return userDataService.createUserData(userDataRequest);
    }
    private boolean isValidEmail(String email){
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return email.matches(regex);
    }
    private boolean isValidMobileNumber(long mobileNumber) {
        String regex = "^\\d{10}$";
        String stringValue = String.valueOf(mobileNumber);
        return stringValue.matches(regex);
    }
    @GetMapping
    public List<UserDataMongo> getAllUserData(){
        return userDataService.getAllUserData();
    }
    @GetMapping("/{id}")
    public List<UserDataResponse> getUserData(@PathVariable String id)
    {
        return userDataService.getUserData(id);
    }
    @PutMapping
    public String updateUserData(@RequestBody UserDataRequest userDataRequest){
        if (!isValidEmail(userDataRequest.getEmail())) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (!isValidMobileNumber(userDataRequest.getMobile_number())) {
            throw new IllegalArgumentException("Invalid mobile number format");
        }
        return userDataService.updateUserData(userDataRequest);
    }
    @DeleteMapping
    public String deleteAllUserData(){
        return userDataService.deleteAllUserData();
    }
    @DeleteMapping("/{id}")
    public String deleteUserData(@PathVariable String id){
        return userDataService.deleteUserData(id);
    }
    @Autowired
    private HealthEndpoint healthEndpoint;

    @GetMapping("/health")
    public HealthComponent getHealth() {
        return healthEndpoint.health();
    }
}
