//package com.mini.project.lib.man.library.management.system.Controller;
//
//import com.mini.project.lib.man.library.management.system.Model.BorrowHistory;
//import com.mini.project.lib.man.library.management.system.Service.BorrowService; // Using BorrowService for return logic
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/return")
//public class ReturnController {
//
//    @Autowired
//    private BorrowService borrowService; // Inject BorrowService as it has the return logic
//
//    // POST method to handle book return by borrow ID
//    // We'll use the service logic that already updates the book and calculates the fine.
//    @PostMapping("/{borrowId}")
//    public ResponseEntity<String> returnBook(@PathVariable Long borrowId) {
//        String response = borrowService.returnBook(borrowId); // Use the existing, complete logic from BorrowService
//        return ResponseEntity.ok(response);
//    }
//}
package com.mini.project.lib.man.library.management.system.Controller;

import com.mini.project.lib.man.library.management.system.Model.BorrowHistory;
import com.mini.project.lib.man.library.management.system.Service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/return")
public class ReturnController {

    @Autowired
    private ReturnService returnService;

    // POST method to handle book return by borrow ID
    @PostMapping("/{borrowId}")
    public ResponseEntity<String> returnBook(@PathVariable Long borrowId) {
        BorrowHistory updatedHistory = returnService.returnBook(borrowId);

        String response = String.format("Book returned successfully. Fine: ₹%.2f", updatedHistory.getFine());

        return ResponseEntity.ok(response);
    }
}