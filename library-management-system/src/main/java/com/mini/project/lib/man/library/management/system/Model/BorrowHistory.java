package com.mini.project.lib.man.library.management.system.Model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Builder
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

   public void markreturn(LocalDate ReturnDate,Double Fine){
       this.ReturnDate=ReturnDate;
       this.Fine=Fine;
       this.Returned=true;
   }
   public BorrowHistory(){

   }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getBorrowDate() {
        return BorrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        BorrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        ReturnDate = returnDate;
    }

    public LocalDate getDueDate() {
        return DueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        DueDate = dueDate;
    }

    public Boolean getReturned() {
        return Returned;
    }

    public void setReturned(Boolean returned) {
        Returned = returned;
    }

    public Double getFine() {
        return Fine;
    }

    public void setFine(Double fine) {
        Fine = fine;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}

