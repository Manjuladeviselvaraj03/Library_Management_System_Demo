//package com.mini.project.lib.man.library.management.system.Service;
//
//import com.mini.project.lib.man.library.management.system.Model.BorrowHistory;
//import com.mini.project.lib.man.library.management.system.Repository.BookRepository;
//import com.mini.project.lib.man.library.management.system.Repository.BorrowRepository;
//import com.mini.project.lib.man.library.management.system.Repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//public class BorrowService {
//    public static List<BorrowHistory> getAllBorrows;
//    @Autowired
//    private BookRepository bookRepository;
//    @Autowired
//    private BorrowRepository borrowRepository;
//    @Autowired
//    private UserRepository userRepository;
////    public String borrowBook()
//    //get all borrow records
//    public List<BorrowHistory> getAllBorrows(){
//        return borrowRepository.findAll();
//    }
//
//
//
//
//    public BorrowHistory getBorrowHistory(Long id) {
//        return null;
//    }
//
//    public BorrowHistory returnBook(Long id, Double fine) {
//
//    }
//
//    public BorrowHistory getAllBorrowById() {
//    }
//}




package com.mini.project.lib.man.library.management.system.Service;

import com.mini.project.lib.man.library.management.system.Model.Book;
import com.mini.project.lib.man.library.management.system.Model.BorrowHistory;
import com.mini.project.lib.man.library.management.system.Model.User;
import com.mini.project.lib.man.library.management.system.Repository.BookRepository;
import com.mini.project.lib.man.library.management.system.Repository.BorrowRepository;
import com.mini.project.lib.man.library.management.system.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class BorrowService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private UserRepository userRepository;

    //  Get all borrow records
    public List<BorrowHistory> getAllBorrows() {
        return borrowRepository.findAll();
    }

    //  Borrow a book
    public String borrowBook(Long userId, Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        if (book.getAvailableCopies() <= 0) {
            return " Book not available right now!";
        }

        // Reduce available copies
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        book.setBorrowCount(book.getBorrowCount() + 1);
        book.setBorrowDate(LocalDate.now());
        bookRepository.save(book);

        // Create borrow history
        BorrowHistory history = new BorrowHistory();
        history.setBook(book);
        history.setUser(user);
        history.setBorrowDate(LocalDate.now());
        history.setDueDate(LocalDate.now().plusDays(14)); // 2 weeks
        history.setReturned(false);
        history.setFine(0.0);

        borrowRepository.save(history);

        return " Book borrowed successfully by " + user.getName();
    }

      //Return a book
    public String returnBook(Long borrowId) {
        BorrowHistory history = borrowRepository.findById(borrowId)
                .orElseThrow(() -> new RuntimeException("Borrow record not found"));

        Book book = history.getBook();
        history.setReturnDate(LocalDate.now());
        history.setReturned(true);

        // Fine logic: ₹10 per day after due date
        long daysLate = ChronoUnit.DAYS.between(history.getDueDate(), LocalDate.now());
        if (daysLate > 0) {
            double fine = daysLate * 10.0;
            history.setFine(fine);
        } else {
            history.setFine(0.0);
        }

        // Increase available copies again
        book.setAvailableCopies(book.getAvailableCopies() + 1);
        bookRepository.save(book);
        borrowRepository.save(history);

        return " Book returned successfully. Fine: ₹" + history.getFine();
    }

    // Get borrow by ID
    public BorrowHistory getBorrowById(Long id) {
        return borrowRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Borrow record not found"));
    }
}
