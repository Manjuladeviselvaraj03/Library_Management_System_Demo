package com.mini.project.lib.man.library.management.system.Service;

import com.mini.project.lib.man.library.management.system.Model.User;
import com.mini.project.lib.man.library.management.system.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    @Autowired
    private UserRepository userrepo;

    public List<User> getAllUser() {
        return userrepo.findAll();
    }

    public User getUserById(Long id) {
        return userrepo.findById(id).get();
    }

    public User addNewUsers(User user) {

        if(userrepo.existsByEmailAndPassword(user))
        return null;
    }

    public User updateNewUser() {
    }

    public void deleteUser(Long id) {

    }
}
