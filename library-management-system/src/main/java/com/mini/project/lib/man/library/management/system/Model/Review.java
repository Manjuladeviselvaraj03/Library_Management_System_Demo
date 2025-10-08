package com.mini.project.lib.man.library.management.system.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.catalina.User;

@Entity
@Table(name = "Review")
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int rating;
    private String comment;

    // multiple reviews given by one user
    @ManyToOne
    @JoinColumn(name = "User id",nullable = false)
    private User user;

    //    multiple reviews given for 1 book
    @ManyToOne
    @JoinColumn(name = "Book id",nullable = false)
    private  Book book;
}
