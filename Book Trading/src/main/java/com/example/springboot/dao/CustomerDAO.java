package com.example.springboot.dao;

import com.example.springboot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerDAO extends JpaRepository<Customer, Long> {

    //find account by phone number
    Optional<Customer> findByPhoneNumber(String phoneID);

    //find account by username
    Optional<Customer> findByUsername(String username);

//    //find account by phone number or by username
//    @Query("SELECT o FROM Customer o WHERE CONCAT(o.phoneNumber, o.username) LIKE ?1")
//    Customer findByKey(String key);
}
