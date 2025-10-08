package com.mini.project.lib.man.library.management.system.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "User")
@Data
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
    List<BorrowHistory> borrowhistory;

}
