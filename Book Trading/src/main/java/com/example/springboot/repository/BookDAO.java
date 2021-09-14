package com.example.springboot.repository;

import com.example.springboot.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface BookDAO extends JpaRepository<Book, Long> {

    //Optional<Book> findByCateCategoryIDLike(Integer categoryID);
}
