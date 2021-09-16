package com.example.springboot.controller.rest;

import com.example.springboot.common.RequestService;
import com.example.springboot.entity.Store;
import com.example.springboot.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    RequestService<Store> storeService;

    @GetMapping
    public ResponseEntity<List<Store>> getAll(){
            return ResponseEntity.ok().body(storeService.findAll());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Store> getOne(@Valid @PathVariable Integer id){
        return ResponseEntity.ok().body(storeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Store> create(@Valid @RequestBody Store store){
        return ResponseEntity.ok().body(storeService.save(store));
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Store> update(@Valid @PathVariable Integer id, @RequestBody Store store){
        return ResponseEntity.ok().body(storeService.save(store));
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @PathVariable Integer id){
        storeService.deleteById(id);
    }
}
