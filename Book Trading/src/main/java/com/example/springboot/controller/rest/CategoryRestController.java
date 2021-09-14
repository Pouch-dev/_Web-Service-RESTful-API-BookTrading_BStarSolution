package com.example.springboot.controller.rest;

import com.example.springboot.entity.Category;
import com.example.springboot.exception.ApiRequestException;
import com.example.springboot.service.implement.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springboot.service.CategoryService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest")
public class CategoryRestController {

    @Autowired
    CategoryServiceImpl cateService;

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
    public ResponseEntity<Category> getOne( @Valid @PathVariable Long id){
            return ResponseEntity.ok().body(cateService.findById(id));
    }

    /**
     * create program
     * @param cate
     * @return
     */
    @PostMapping("/category")
    public ResponseEntity<Category> create( @Valid @RequestBody Category cate){
            return ResponseEntity.ok().body(cateService.save(cate));
    }

    /**
     * update program
     * @param id
     * @param cate
     * @return
     */
    @PutMapping("/category/{id}")
    public ResponseEntity<Category> update(@PathVariable Integer id, @Valid @RequestBody Category cate){
            return ResponseEntity.ok().body(cateService.save(cate));
    }

    /**
     * delete program
     * @param id
     */
    @DeleteMapping("/category/{id}")
    public void delete( @Valid @PathVariable Long id){
            cateService.deleteById(id);
    }
}
