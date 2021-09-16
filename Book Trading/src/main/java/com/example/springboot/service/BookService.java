package com.example.springboot.service;

import com.example.springboot.entity.Product;
import com.example.springboot.model.AddProduct;
import com.example.springboot.model.UpdateBook;

import java.util.List;

public interface BookService {
    List<Product> findAll();

    Product save(AddProduct bookDto);

    Product findById(Integer bookId);

    void deleteById(Integer bookId);

    Product updateBook(UpdateBook updateBook);

    List<Product> findByCateCategoryId(Integer categoryId);
}
