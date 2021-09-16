package com.example.springboot.repository;

import com.example.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDAO extends JpaRepository<Product, Integer> {

    List<Product> findByCateCategoryId(Integer categoryId);

    //Optional<Book> findByCateCategoryIDLike(Long categoryID);
}
