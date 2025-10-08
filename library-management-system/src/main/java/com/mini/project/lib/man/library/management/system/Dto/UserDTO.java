package com.mini.project.lib.man.library.management.system.Dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UserDTO {
    private Long  id;
    private  String Name;
    private int TotalBooksBorrowed;
    private int CurrentStreak;
}
