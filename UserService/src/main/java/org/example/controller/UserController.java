package org.example.controller;

import org.example.UserServiceApplication;
import org.example.dto.UserRequest;
import org.example.dto.UserResponse;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping
   public UserResponse createUser(@RequestBody UserRequest userRequest){
        if (!isValidMobileNumber(userRequest.getMobile_number())) {
            throw new IllegalArgumentException("Invalid mobile number format");
        }
       return userService.createUserData(userRequest);
   }
    private boolean isValidMobileNumber(long mobileNumber) {
        String regex = "^\\d{10}$";
        String stringValue = String.valueOf(mobileNumber);
        return stringValue.matches(regex);
    }
   @GetMapping
    public List<User> updateUser(){
        return userService.getAllUserData();
   }
   @GetMapping("/{id}")
   public List<UserResponse> getFilterUserData(@PathVariable String id){
        return userService.getFilterUserData(id);
   }
   @DeleteMapping("/{name}")
    public String deleteUser(@PathVariable String name){
        return userService.deleteUser(name);
   }
   @DeleteMapping
   public String deleteAllUsers(){
        return userService.deleteAllUsers();
   }
   @PutMapping()
   public String updateUser(@RequestBody UserRequest userRequest){
        return userService.updateUser(userRequest);
   }
}
