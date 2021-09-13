package com.example.springboot.dao;

import com.example.springboot.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreDAO extends JpaRepository<Store, Integer> {
}
