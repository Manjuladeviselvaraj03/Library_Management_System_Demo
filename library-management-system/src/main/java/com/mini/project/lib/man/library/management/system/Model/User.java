package com.mini.project.lib.man.library.management.system.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "User")
@Data
@Builder
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @Email
    private String email;
    @Size(min = 4,max = 9)
    private String password;

    private LocalDate joindate;
    private int totalBooksBorrowed;
    private int currentStreak;


    @OneToMany(mappedBy = "User",cascade = CascadeType.ALL)
    List<BorrowHistory> borrowhistory;

}
