//package com.mini.project.lib.man.library.management.system.Controller;
//
//import com.mini.project.lib.man.library.management.system.Service.ReportService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/report")
//public class ReportController {
//
//    @Autowired
//    private ReportService reportService;
//
//    //Get Trending Books
//
//    @GetMapping("/trending")
//    public Map<String, Integer> getTrendingBook(){
//        return reportService.getTrendingBooks();
//    }
//
//    //Get Overdue Books & fine
//    @GetMapping("/overdue")
//    public Map<String, Integer> getOverdueBooks(){
//        return reportService.getOverdueBooks();
//    }
//
//
//}
