package com.mini.project.lib.man.library.management.system.Repository;

import com.mini.project.lib.man.library.management.system.Model.BorrowHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReturnRepository   extends JpaRepository<BorrowHistory, Long> {
}
