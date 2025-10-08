package com.mini.project.lib.man.library.management.system.Model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Review")
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int Rating;
    private String Comment;

// multiple reviews given by one user
    @ManyToOne
    @JoinColumn(name = "User id",nullable = false)
    private User user;

//    multiple reviews given for 1 book
    @ManyToOne
    @JoinColumn(name = "Book id",nullable = false)
    private  Book book;
}
