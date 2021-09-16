package com.example.springboot.controller.rest;

import com.example.springboot.entity.Customer;
import com.example.springboot.model.AddCustomer;
import com.example.springboot.model.UpdateCustomer;
import com.example.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService custService;
    @Autowired
    BCryptPasswordEncoder pe;

    /**
     * getAll program
     * @return
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAll(){
            return custService.findAll();
    }

    /**
     * getOne program
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getOne( @Valid @PathVariable Integer id, @RequestBody Customer customer){
            System.out.println("User "+customer.getUsername()+" with password: "+pe.encode(customer.getPassword()));
            return ResponseEntity.ok().body(custService.findById(id));
    }

    /**
     * create program
     * @param customer
     * @return
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create( @Valid @RequestBody AddCustomer customer){
            System.out.println("User "+customer.getUsername()+" with password: "+pe.encode(customer.getPassword()));
            custService.save(customer);
    }

    /**
     * update program
     * @param id
     * @param customer
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable Integer id, @RequestBody @Valid UpdateCustomer customer){
            System.out.println("User "+customer.getUsername()+" with password: "+pe.encode(customer.getPassword()));
            return ResponseEntity.ok().body(custService.updateCustomer(customer));
    }

    /**
     * delete program
     * @param id
     */
    @DeleteMapping("/{id}")
    public void delete( @Valid @PathVariable Integer id){
        custService.deleteById(id);
    }

    /**
     * getPhone program
     * @param phoneID
     * @param customer
     * @return
     */
    //find account by phone number
    @GetMapping("/phone/{phoneID}")
    public ResponseEntity<Customer> getPhone(@PathVariable String phoneID,@RequestBody @Valid Customer customer){
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
    @GetMapping("/username/{user}")
    public ResponseEntity<Customer> getUsername(@PathVariable String user, @RequestBody @Valid Customer customer){
            System.out.println("User "+customer.getUsername()+" with password: "+pe.encode(customer.getPassword()));
            return ResponseEntity.ok().body(custService.findByUsername(user));
    }

//    //find account by username
    @GetMapping("/phoneorusername/{key}")
    public List<Customer> getPhoneNumberOrUsername(@PathVariable String key, @RequestBody Customer customer){
            System.out.println("User "+customer.getUsername()+" with password: "+pe.encode(customer.getPassword()));
            return custService.findByKey(key);
    }
}
