package com.example.springboot.repository;

import com.example.springboot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer> {

    //find account by phone number
    Optional<Customer> findByPhoneNumber(String phoneID);

    //find account by username
    Optional<Customer> findByUsername(String username);

    //find account by phone number or by username
    @Query("SELECT o FROM Customer o WHERE CONCAT(o.phoneNumber, o.username) LIKE '%key%'")
    List<Customer> findByKey(String key);
}
