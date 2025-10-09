package com.mini.project.lib.man.library.management.system.Service;

import com.mini.project.lib.man.library.management.system.Model.User;
import com.mini.project.lib.man.library.management.system.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class UserService {

    @Autowired
    private UserRepository userrepo;

    public List<User> getAllUser() {
        return userrepo.findAll();
    }

    public User getUserById(Long id) {
        return userrepo.findById(id).orElseThrow(() -> new RuntimeException("User not found: " + id));
    }

    public User addNewUsers(User user) {
        user.setJoindate(LocalDate.now());
        user.setTotalBooksBorrowed(0);
        user.setCurrentStreak(0);
        return userrepo.save(user);
    }

    public User updateNewUser(Long id, User userDetails) {
        User existingUser = getUserById(id);
        existingUser.setName(userDetails.getName());
        existingUser.setEmail(userDetails.getEmail());
        if (userDetails.getPassword() != null && !userDetails.getPassword().isEmpty()) {
            existingUser.setPassword(userDetails.getPassword());
        }
        return userrepo.save(existingUser);
    }

    public void deleteUser(Long id) {
        userrepo.deleteById(id);
    }
}