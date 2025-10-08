package com.mini.project.lib.man.library.management.system.Model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "BorrowHistory")
public class BorrowHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate BorrowDate;
    private LocalDate ReturnDate;
    private LocalDate DueDate;
    private Boolean Returned;
    private Double Fine;

    @OneToMany
    @JoinColumn(name = "User id",nullable = false)
    private User user;
    @OneToMany
    @JoinColumn(name = "Book id",nullable = false)
    private Book book;
}
