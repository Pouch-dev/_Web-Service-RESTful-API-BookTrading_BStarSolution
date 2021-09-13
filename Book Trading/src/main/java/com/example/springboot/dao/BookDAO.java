package com.example.springboot.dao;

import com.example.springboot.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BookDAO extends JpaRepository<Book, Integer> {

//    @Query("SELECT o FROM Book o where o.cate.categoryID like ?1")
//    Optional<Book> findByCateCategoryID (Integer id);
}
