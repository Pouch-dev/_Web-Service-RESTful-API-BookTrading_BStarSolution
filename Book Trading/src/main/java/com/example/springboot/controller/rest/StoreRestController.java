package com.example.springboot.controller.rest;

import com.example.springboot.entity.Store;
import com.example.springboot.exception.ApiRequestException;
import com.example.springboot.service.implement.StoreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class StoreRestController {

    @Autowired
    StoreServiceImpl storeService;

    @GetMapping("/store")
    public ResponseEntity<List<Store>> getAll(){
            return ResponseEntity.ok().body(storeService.findAll());
    }

    @GetMapping("/store/{id}")
    public  ResponseEntity<Store> getOne(@Valid @PathVariable Long id){
        return ResponseEntity.ok().body(storeService.findById(id));
    }

    @PostMapping("/store")
    public ResponseEntity<Store> create(@Valid @RequestBody Store store){
        return ResponseEntity.ok().body(storeService.save(store));
    }

    @PutMapping("/store/{id}")
    public  ResponseEntity<Store> update(@Valid @PathVariable Long id, @RequestBody Store store){
        return ResponseEntity.ok().body(storeService.save(store));
    }

    @DeleteMapping("/store/{id}")
    public void delete(@Valid @PathVariable Long id){
        storeService.deleteById(id);
    }
}
