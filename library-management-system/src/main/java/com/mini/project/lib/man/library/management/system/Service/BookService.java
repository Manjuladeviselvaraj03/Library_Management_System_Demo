package com.mini.project.lib.man.library.management.system.Service;

import com.mini.project.lib.man.library.management.system.Model.Book;
import com.mini.project.lib.man.library.management.system.Repository.BookRepository;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return  bookRepository.findAll();

    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Book not found" + id));
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }
//
//    public Book updateBook(SingularAttribute<AbstractPersistable, Serializable> id, Book book) {
//    }
    public Book updateBook(Long id, Book bookDetials) {
        Book existingBook=getBookById(id);
        existingBook.setTitle(bookDetials.getTitle());
        existingBook.setBookAuthor(bookDetials.getBookAuthor());
        existingBook.setTotalCopies(bookDetials.getTotalCopies());
        existingBook.setAvailableCopies(bookDetials.getAvailableCopies());
        existingBook.setBorrowCount(bookDetials.getBorrowCount());
        return bookRepository.save(existingBook);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
