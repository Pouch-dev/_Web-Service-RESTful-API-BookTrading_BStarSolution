package com.example.springboot.common;

import java.util.List;

public abstract class RequestService <Product>{

    public abstract List<Product> findAll();

    public abstract Product save(Product entity);

    public abstract Product findById(Integer integer);

    public abstract void deleteById(Integer integer);
}
