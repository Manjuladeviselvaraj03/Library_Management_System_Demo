package com.mini.project.lib.man.library.management.system.Repository;

import com.mini.project.lib.man.library.management.system.Model.User;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
User findByEmail(@Email String email);
//   @Query("SELECT u from User WHERE u.email=:email AND password=:password");
//   List<User>findByEmail(@Param("Email")String Email,@Param("Password")String Password);
}
