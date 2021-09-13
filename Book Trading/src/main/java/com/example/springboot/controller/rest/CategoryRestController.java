package com.example.springboot.controller.rest;

import com.example.springboot.entity.Category;
import com.example.springboot.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springboot.service.CategoryService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest")
public class CategoryRestController {

    @Autowired
    CategoryService cateService;

    /**
     * getAll program
     * @return
     */
    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAll(){
            return ResponseEntity.ok().body(cateService.findAll());
    }

    /**
     * getOne program
     * @param id
     * @return
     */
    @GetMapping("/category/{id}")
    public ResponseEntity<Category> getOne(@PathVariable Integer id){
            return ResponseEntity.ok().body(cateService.findById(id));
    }

    /**
     * create program
     * @param cate
     * @return
     */
    @PostMapping("/category")
    public ResponseEntity<Category> create(@RequestBody Category cate){
            return ResponseEntity.ok().body(cateService.save(cate));
    }

    /**
     * update program
     * @param id
     * @param cate
     * @return
     */
    @PutMapping("/category/{id}")
    public ResponseEntity<Category> update(@PathVariable Integer id, @RequestBody Category cate){
            return ResponseEntity.ok().body(cateService.save(cate));
    }

    /**
     * delete program
     * @param id
     */
    @DeleteMapping("/category/{id}")
    public void delete(@PathVariable Integer id){
            cateService.deleteById(id);
    }
}
