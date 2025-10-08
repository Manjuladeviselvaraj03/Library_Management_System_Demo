package com.mini.project.lib.man.library.management.system.Dto;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class BookDTO {
    private Long BookId;
    private  String Title;
    private String BookAuthor;
    private int TotalCopies;
    private int AvailableCopies;
    private  int BorrowCount;
    private LocalDate BorrowDate;

}
