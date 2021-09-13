package com.example.springboot.controller.rest;

import com.example.springboot.dao.CategoryDAO;
import com.example.springboot.dao.BookDAO;
import com.example.springboot.entity.Book;
import com.example.springboot.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springboot.service.BookService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest")
public class BookRestController {

    @Autowired
    BookService proService;
    @Autowired
    CategoryDAO CateDAO;

    /**
     * getAll program
     * @return
     */
    @GetMapping("/book")
    public ResponseEntity<List<Book>> getAll(){
            return ResponseEntity.ok().body(proService.findAll());
    }

    /**
     * getOne program
     * @param id
     * @return
     */
    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getOne(@PathVariable Integer id){
            return ResponseEntity.ok().body(proService.findById(id));
    }

    /**
     * create program
     * @param pro
     * @return
     */
    @PostMapping("/book")
    public ResponseEntity<Book> create(@RequestBody Book pro){
            int cateID = pro.getCate().getCategoryID();
            CateDAO.findById(cateID).orElseThrow(() -> new ApiRequestException("Oops can't create book because "+cateID+" is null"));
            return ResponseEntity.ok().body(proService.save(pro));
    }

    /**
     * update program
     * @param id
     * @param pro
     * @return
     */
    @PutMapping("/book/{id}")
    public ResponseEntity<Book> update(@PathVariable Integer id, @RequestBody Book pro){
            return ResponseEntity.ok().body(proService.save(pro));
    }

    /**
     * delete program
     * @param id
     */
    @DeleteMapping("/book/{id}")
    public void delete(@PathVariable Integer id){
            proService.deleteById(id);
    }


//    //find by category
//    @GetMapping("/category/book/{id}")
//    public Book getByCate(@PathVariable Integer id){
//        return  proService.findByCateCategoryID(id);
//    }
}
