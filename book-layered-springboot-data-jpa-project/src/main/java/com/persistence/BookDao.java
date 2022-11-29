package com.persistence;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Book;

@Repository
public interface BookDao extends JpaRepository<Book, Integer> {
    //List<Book> findByBookName(String bookName);
}


