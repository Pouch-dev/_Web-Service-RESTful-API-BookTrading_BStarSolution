package com.example.springboot.controller.rest;

import com.example.springboot.entity.Customer;
import com.example.springboot.exception.ApiRequestException;
import com.example.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest")
public class CustomerRestController {

    @Autowired
    CustomerService custService;
    @Autowired
    BCryptPasswordEncoder pe;

    /**
     * getAll program
     * @return
     */
    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getAll(){
            return ResponseEntity.ok().body(custService.findAll());
    }

    /**
     * getOne program
     * @param id
     * @return
     */
    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getOne(@PathVariable Long id, @RequestBody Customer customer){
            System.out.println("User "+customer.getUsername()+" with password: "+pe.encode(customer.getPassword()));
            return ResponseEntity.ok().body(custService.findById(id));
    }

    /**
     * create program
     * @param customer
     * @return
     */
    @PostMapping("/customer")
    public ResponseEntity<Customer> create(@RequestBody Customer customer){
            System.out.println("User "+customer.getUsername()+" with password: "+pe.encode(customer.getPassword()));
            return ResponseEntity.ok().body(custService.save(customer));
    }

    /**
     * update program
     * @param id
     * @param customer
     * @return
     */
    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> update(@PathVariable Integer id, @RequestBody Customer customer){
            System.out.println("User "+customer.getUsername()+" with password: "+pe.encode(customer.getPassword()));
            return ResponseEntity.ok().body(custService.save(customer));
    }

    /**
     * delete program
     * @param id
     */
    @DeleteMapping("/customer/{id}")
    public void delete(@PathVariable Long id){
        custService.deleteById(id);
    }

    /**
     * getPhone program
     * @param phoneID
     * @param customer
     * @return
     */
    //find account by phone number
    @GetMapping("/customer/phone/{phoneID}")
    public ResponseEntity<Customer> getPhone(@PathVariable String phoneID,@RequestBody Customer customer){
            System.out.println("User "+customer.getUsername()+" with password: "+pe.encode(customer.getPassword()));
            return ResponseEntity.ok().body(custService.findByPhoneNumber(phoneID));
    }

    /**
     * getUsername program
     * @param user
     * @param customer
     * @return
     */
    //find account by username
    @GetMapping("/customer/username/{user}")
    public ResponseEntity<Customer> getUsername(@PathVariable String user, @RequestBody @Valid Customer customer){
            System.out.println("User "+customer.getUsername()+" with password: "+pe.encode(customer.getPassword()));
            return ResponseEntity.ok().body(custService.findByUsername(user));
    }

//    //find account by username
//    @GetMapping("/customer/phoneorusername/{key}")
//    public Customer getPhoneNumberOrUsername(@PathVariable String key,@RequestBody Customer customer){
//            System.out.println("User "+customer.getUsername()+" with password: "+pe.encode(customer.getPassword()));
//            return custService.findByKey(key);
//    }
}
