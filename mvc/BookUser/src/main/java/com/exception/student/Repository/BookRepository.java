package com.exception.student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exception.student.Entity.Book;
import com.exception.student.Entity.User;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

}
