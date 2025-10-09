//package com.example.libraryapp.service;
//
//import com.example.libraryapp.model.BorrowHistory;
//import com.example.libraryapp.repository.BorrowRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.time.LocalDate;
//import java.time.temporal.ChronoUnit;
//
//@Service
//public class ReturnService {
//
//    @Autowired
//    private BorrowRepository borrowRepository;
//
//    public BorrowHistory returnBook(Long borrowId) {
//        BorrowHistory history = borrowRepository.findById(borrowId)
//                .orElseThrow(() -> new RuntimeException("Borrow record not found"));
//
//        LocalDate today = LocalDate.now();
//        history.setReturnDate(today);
//
//        long daysLate = ChronoUnit.DAYS.between(history.getDueDate(), today);
//
//        if (daysLate > 0) {
//            double fine = daysLate * 10.0; // ₹10 per day
//            history.setFine(fine);
//        } else {
//            history.setFine(0.0);
//        }
//
//        return borrowRepository.save(history);
//    }
//}
package com.mini.project.lib.man.library.management.system.Service;

import com.mini.project.lib.man.library.management.system.Model.Book;
import com.mini.project.lib.man.library.management.system.Model.BorrowHistory;
import com.mini.project.lib.man.library.management.system.Repository.BookRepository;
import com.mini.project.lib.man.library.management.system.Repository.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class ReturnService {

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private BookRepository bookRepository; // Needed to update available copies


    public BorrowHistory returnBook(Long borrowId) {
        // 1. Fetch the borrow record
        BorrowHistory history = borrowRepository.findById(borrowId)
                .orElseThrow(() -> new RuntimeException("Borrow record not found with ID: " + borrowId));

        if (history.getReturned()) {
            throw new RuntimeException("Book with Borrow ID " + borrowId + " has already been returned.");
        }

        LocalDate today = LocalDate.now();
        history.setReturnDate(today);
        history.setReturned(true);

        // 2. Fine calculation: ₹10 per day after the due date
        long daysLate = ChronoUnit.DAYS.between(history.getDueDate(), today);

        if (daysLate > 0) {
            double fine = daysLate * 10.0; // ₹10 per day
            history.setFine(fine);
        } else {
            history.setFine(0.0);
        }

        // 3. Update the Book's available copies
        Book book = history.getBook();
        book.setAvailableCopies(book.getAvailableCopies() + 1);
        bookRepository.save(book);

        // 4. Save the updated borrow history
        return borrowRepository.save(history);
    }
}