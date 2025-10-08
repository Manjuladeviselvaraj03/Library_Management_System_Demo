package com.mini.project.lib.man.library.management.system.Controller;

import com.mini.project.lib.man.library.management.system.Model.BorrowHistory;
import com.mini.project.lib.man.library.management.system.Service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/borrow")
public class BorrowController {
    @Autowired
    private BorrowService borrowService;


    //to fetch borrow history
    @PostMapping
    public ResponseEntity<BorrowHistory> getBorrowHistory(@PathVariable Long id){
        BorrowHistory saved=borrowService.getBorrowHistory(id);
        return ResponseEntity.ok(saved);
    }


    //calculate fine
    @PutMapping("/return/{id}")
    public ResponseEntity<BorrowHistory> returnBook(@PathVariable Long id, @RequestParam  Double fine){
        BorrowHistory retruned=borrowService.returnBook(id,fine);
        return  ResponseEntity.ok(retruned);
    }

//    @PutMapping("/return/{id}")
//    public ResponseEntity<BorrowHistory> returnBook(@PathVariable Long id, @RequestParam Double fine) {
//        BorrowHistory returned = borrowService.returnBook(id, fine);
//        return ResponseEntity.ok(returned);
//    }




    //Get All Borrowed by id
    @GetMapping
    public List<BorrowHistory> getAllBorrows(){
        return  BorrowService.getAllBorrows;
    }

    //Get all by borrow by Id
    @GetMapping("/{id}")
    public ResponseEntity<BorrowHistory> getAllBorrowById(@PathVariable Long id){
        BorrowHistory getAllBorrowById= borrowService.getAllBorrowById();
        return ResponseEntity.ok(getAllBorrowById);
    }

}
