package com.mini.project.lib.man.library.management.system.Model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@Builder
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Name;
    private String Email;
    private String Password;

    private LocalDate Joindate;
    private int TotalBooksBorrowed;
    private int CurrentStreak;


    @OneToMany(mappedBy = "User",cascade = CascadeType.ALL)
    List<BorrowHistory>borrowhistory;

//    public User() {
//
//    }
//
//    public User(Long id, String name, String email, String password, LocalDate joindate, int totalBooksBorrowed, int currentStreak) {
//        this.id = id;
//        this.Name = name;
//        this. Email = email;
//        this.Password = password;
//        this.Joindate = joindate;
//        this.TotalBooksBorrowed = totalBooksBorrowed;
//        this.CurrentStreak = currentStreak;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public LocalDate getJoindate() {
        return Joindate;
    }

    public void setJoindate(LocalDate joindate) {
        Joindate = joindate;
    }

    public int getTotalBooksBorrowed() {
        return TotalBooksBorrowed;
    }

    public void setTotalBooksBorrowed(int totalBooksBorrowed) {
        TotalBooksBorrowed = totalBooksBorrowed;
    }

    public int getCurrentStreak() {
        return CurrentStreak;
    }

    public void setCurrentStreak(int currentStreak) {
        CurrentStreak = currentStreak;
    }
}