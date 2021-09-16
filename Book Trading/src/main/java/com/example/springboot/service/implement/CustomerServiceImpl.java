package com.example.springboot.service.implement;

import com.example.springboot.common.RequestService;
import com.example.springboot.model.AddCustomer;
import com.example.springboot.model.UpdateCustomer;
import com.example.springboot.repository.CustomerDAO;
import com.example.springboot.entity.Customer;
import com.example.springboot.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.springboot.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

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
    public Customer save(AddCustomer customerDto) {
        Customer customer = new Customer();
        customer.convertFromAddCustomer(customerDto);
        return useDAO.save(customer);
    }

    @Override
    public Customer updateCustomer(UpdateCustomer updateCustomer) {
        Customer customer = useDAO.findById(updateCustomer.getCustomerId()).orElseThrow(() -> new ApiRequestException(
            String.format("Not found customer with id = [%d]", updateCustomer.getCustomerId())
        ));
        customer.setUsername(updateCustomer.getUsername());
        customer.setPassword(updateCustomer.getPassword());
        customer.setFullName(updateCustomer.getFullName());
        customer.setPhoneNumber(updateCustomer.getPhoneNumber());
        customer.setAddress(updateCustomer.getAddress());
        return useDAO.save(customer);
    }

    @Override
    public Customer findById(Integer customerId) {
        return useDAO.findById(customerId).orElseThrow(() -> new ApiRequestException(
                String.format("Can't get customer id [%d]",customerId)
        ));
    }

    @Override
    public void deleteById(Integer integer) {
        try{
            useDAO.deleteById(integer);
        }catch (Exception e){
            throw new ApiRequestException("Oops can't delete customer");
        }
    }

    @Override
    public Customer findByPhoneNumber(String phoneID) {
        return useDAO.findByPhoneNumber(phoneID).orElseThrow(() -> new ApiRequestException(
                String.format(("Can't get customer by id"))
        ));
    }

    @Override
    public Customer findByUsername(String username) {
        return useDAO.findByUsername(username).orElseThrow(() -> new ApiRequestException("Oops can't get by username customer"));
    }

    @Override
    public List<Customer> findByKey(String key) {
        return useDAO.findByKey(key);
    }
}
