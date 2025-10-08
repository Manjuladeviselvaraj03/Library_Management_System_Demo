package com.mini.project.lib.man.library.management.system.Controller;

import com.mini.project.lib.man.library.management.system.Model.Book;
import com.mini.project.lib.man.library.management.system.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    //To see all the books
    public List<Book> getAllBooks(){
        return  bookService.getAllBooks();
    }

    //For getting book id
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        Book book=bookService.getBookById(id);
        return ResponseEntity.ok(book);///////////////////////////////////////////////////////
    }

    //Add new Book
    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book saved=bookService.addBook(book);
        return ResponseEntity.ok(saved);
    }

    //Update the Book
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        Book updated=bookService.updateBook(id,book);
        return ResponseEntity.ok(updated);



    }

    public ResponseEntity<String> deleteBook(@PathVariable Long id){
        bookService.delteBook(id);
        return ResponseEntity.ok("Book deleted successfully");
    }


}
