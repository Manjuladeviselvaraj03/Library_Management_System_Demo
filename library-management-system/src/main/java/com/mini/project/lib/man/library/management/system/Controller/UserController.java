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

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUser();
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);

    }

    //Add new user
    @PostMapping
    public ResponseEntity<User> addNewUser(@RequestBody User user){
        User saved = userService.addNewUsers(user);
        return ResponseEntity.ok(saved);
    }

    //Update existing user
    @PutMapping("/{id}") // Corrected mapping from /"{id]" to "/{id}"
    public ResponseEntity<User> updateNewUser(@PathVariable Long id, @RequestBody User user){
        User update = userService.updateNewUser(id, user); // Corrected method call signature
        return ResponseEntity.ok(update);
    }

    //Delete user
    @DeleteMapping("/{id}") // Added path variable to delete
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}