package com.mini.project.lib.man.library.management.system.Model;

import jakarta.persistence.*;
import lombok.Data;

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

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    public BorrowHistory() {
    }
}