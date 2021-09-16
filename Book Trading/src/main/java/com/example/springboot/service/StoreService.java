package com.example.springboot.service;

import com.example.springboot.entity.Store;

import java.util.List;

public interface StoreService {
    List<Store> findAll();

    Store save(Store store);

    Store findById(Integer storeId);

    void deleteById(Integer storeId);
}
