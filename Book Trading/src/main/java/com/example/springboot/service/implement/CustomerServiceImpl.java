package com.example.springboot.service.implement;

import com.example.springboot.common.RequestService;
import com.example.springboot.repository.CustomerDAO;
import com.example.springboot.entity.Customer;
import com.example.springboot.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.springboot.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl extends RequestService<Customer> implements CustomerService {

    @Autowired
    CustomerDAO useDAO;

    @Override
    public List<Customer> findAll() {
        try {
            return useDAO.findAll();
        }catch (Exception e){
            throw new ApiRequestException("Oops can't get all customer");
        }
    }

    @Override
    public <S extends Customer> S save(S entity) {
        try{
            return useDAO.save(entity);
        }catch (Exception e){
            throw new ApiRequestException("Oops can't save customer");
        }
    }

    @Override
    public Customer findById(Long integer) {
        return useDAO.findById(integer).orElseThrow(() -> new ApiRequestException("Oops can't get one customer"));
    }

    @Override
    public void deleteById(Long integer) {
        try{
            useDAO.deleteById(integer);
        }catch (Exception e){
            throw new ApiRequestException("Oops can't delete customer");
        }
    }

    @Override
    public Customer findByPhoneNumber(String phoneID) {
        return useDAO.findByPhoneNumber(phoneID).orElseThrow(() -> new ApiRequestException("Oops can't get by phone customer"));
    }

    @Override
    public Customer findByUsername(String username) {
        return useDAO.findByUsername(username).orElseThrow(() -> new ApiRequestException("Oops can't get by username customer"));
    }

//    @Override
//    public Customer findByKey(String key) {
//        return useDAO.findByKey(key);
//    }
}
