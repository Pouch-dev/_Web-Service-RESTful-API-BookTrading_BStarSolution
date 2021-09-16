package com.example.springboot.repository;

import com.example.springboot.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreDAO extends JpaRepository<Store, Integer> {
}
