package com.mini.project.lib.man.library.management.system.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name="Book")
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long BookID;
    @Column(nullable = false)
    private String Title;

    private String BookAuthor;
    @Column(name="Total_Copies")
    private int TotalCopies;
    @Column(name="Available_Copies")
    private int AvailableCopies;

    private int BorrowCount;
    private LocalDate BorrowDate;
    public Book() {

    }
    public Book(long bookID, String title, String bookAuthor, int totalCopies, int availableCopies, int borrowCount, LocalDate borrowDate) {
        BookID = bookID;
        Title = title;
        BookAuthor = bookAuthor;
        TotalCopies = totalCopies;
        AvailableCopies = availableCopies;
        BorrowCount = borrowCount;
        BorrowDate = borrowDate;
    }

    public long getBookID() {
        return BookID;
    }

    public void setBookID(long bookID) {
        BookID = bookID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getBookAuthor() {
        return BookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        BookAuthor = bookAuthor;
    }

    public int getBorrowCount() {
        return BorrowCount;
    }

    public void setBorrowCount(int borrowCount) {
        BorrowCount = borrowCount;
    }

    public LocalDate getBorrowDate() {
        return BorrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        BorrowDate = borrowDate;
    }

    public int getTotalCopies() {
        return TotalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        TotalCopies = totalCopies;
    }

    public int getAvailableCopies() {
        return AvailableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        AvailableCopies = availableCopies;
    }
}
