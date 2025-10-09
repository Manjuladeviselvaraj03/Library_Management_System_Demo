package com.mini.project.lib.man.library.management.system.Repository;

import com.mini.project.lib.man.library.management.system.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
