package com.example.springboot.controller.rest;

import com.example.springboot.entity.Category;
import com.example.springboot.model.AddCategory;
import com.example.springboot.model.UpdateCategory;
import com.example.springboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService cateService;

    /**
     * getAll program
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Category>> getAll(){
            return ResponseEntity.ok().body(cateService.getListCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getOneById( @Valid @PathVariable Integer id){
            return ResponseEntity.ok().body(cateService.getCategory(id));
    }

    @PostMapping
    public void create(@Valid @RequestBody AddCategory addCategory){
            ResponseEntity.ok().body(cateService.createCategory(addCategory));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable Integer id, @Valid @RequestBody UpdateCategory updateCategory){
            return ResponseEntity.ok().body(cateService.updateCategory(updateCategory));
    }

    @DeleteMapping("/category/{id}")
    public void delete( @Valid @PathVariable Integer id){
            cateService.deleteById(id);
    }
}
