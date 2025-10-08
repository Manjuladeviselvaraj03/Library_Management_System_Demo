package com.mini.project.lib.man.library.management.system.Service;

import com.mini.project.lib.man.library.management.system.Model.Book;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.io.Serializable;
import java.util.List;

public class BookService {
    public List<Book> getAllBooks() {
    }

    public Book getBookById(Long id) {
    }

    public Book addBook(Book book) {
    }

    public Book updateBook(SingularAttribute<AbstractPersistable, Serializable> id, Book book) {
    }

    public void delteBook(Long id) {
    }
}
