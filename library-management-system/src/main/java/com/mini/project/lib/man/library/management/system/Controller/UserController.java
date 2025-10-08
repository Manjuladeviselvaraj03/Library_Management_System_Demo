package com.mini.project.lib.man.library.management.system.Controller;


import com.mini.project.lib.man.library.management.system.Model.User;
import com.mini.project.lib.man.library.management.system.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //getAll Users
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    //get user by id
    @RequestMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User User=userService.getUserById(id);
        return ResponseEntity.ok(User);

    }

    //Add new user
    @PostMapping
    public ResponseEntity<User> addNewUser(@RequestBody User user){
        User saved=userService.addNewUsers();
        return ResponseEntity.ok(saved);
    }

    //Update new user
    @PutMapping("/{id]")
    public ResponseEntity<User> updateNewUser(@PathVariable Long id,@RequestBody User user){
        User update=userService.updateNewUser();
        return ResponseEntity.ok(update);
    }
    //Delete

    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }



}
