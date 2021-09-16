package com.example.springboot.service;

import com.example.springboot.entity.Customer;
import com.example.springboot.model.AddCustomer;
import com.example.springboot.model.UpdateCustomer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer save(AddCustomer customer);

    Customer updateCustomer(UpdateCustomer updateCustomer);

    Customer findById(Integer integer);

    void deleteById(Integer integer);

    Customer findByPhoneNumber(String phoneID);

    Customer findByUsername(String user);

    List<Customer> findByKey(String key);
}
