package com.mini.project.lib.man.library.management.system.Model;

import jakarta.persistence.*;
//import lombok.Builder;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Table(name="Categories")
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CategoryID")
    private long  Id;
    private String Name;
    @OneToMany(mappedBy = "Category",cascade = CascadeType.ALL)
    private List<Book> Books;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Book> getBooks() {
        return Books;
    }

    public void setBooks(List<Book> books) {
        Books = books;
    }

//    public Category(long id, String name, List<Book> books) {
//        Id = id;
//        Name = name;
//        Books = books;
//    }
//    public Category() {
//
//    }
}
