package com.example.springboot.controller.rest;

import com.example.springboot.entity.Product;
import com.example.springboot.model.AddProduct;
import com.example.springboot.model.UpdateBook;
import com.example.springboot.repository.CategoryDAO;
import com.example.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService proService;
    @Autowired
    CategoryDAO CateDAO;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok().body(proService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getOne(@Valid @PathVariable Integer id) {
        return ResponseEntity.ok().body(proService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody AddProduct book) {
        proService.save(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@Valid @RequestBody UpdateBook updateBook) {
        return ResponseEntity.ok().body(proService.updateBook(updateBook));
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @PathVariable Integer id) {
        proService.deleteById(id);
    }

    //find by category
    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> getByCate(@PathVariable Integer id) {
        return ResponseEntity.ok().body(proService.findByCateCategoryId(id));
    }
}

//  Get request
//  Post request
