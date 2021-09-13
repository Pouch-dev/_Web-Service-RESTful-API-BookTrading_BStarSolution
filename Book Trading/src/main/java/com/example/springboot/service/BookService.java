package com.example.springboot.service;

import com.example.springboot.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    <S extends Book> S save(S entity);

    Book findById(Integer integer);

    void deleteById(Integer integer);

//    Book findByCateCategoryID(Integer id);
}
