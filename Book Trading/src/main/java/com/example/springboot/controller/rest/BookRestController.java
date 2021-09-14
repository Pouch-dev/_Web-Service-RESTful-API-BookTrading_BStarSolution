package com.example.springboot.controller.rest;

import com.example.springboot.repository.CategoryDAO;
import com.example.springboot.entity.Book;
import com.example.springboot.exception.ApiRequestException;
import com.example.springboot.service.implement.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springboot.common.RequestService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest")
public class BookRestController {

    @Autowired
    BookServiceImpl proService;
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
    public ResponseEntity<Book> getOne( @Valid @PathVariable Long id){
            return ResponseEntity.ok().body(proService.findById(id));
    }

    /**
     * create program
     * @param pro
     * @return
     */
    @PostMapping("/book")
    public ResponseEntity<Book> create( @Valid @RequestBody Book pro){
            Long cateID = pro.getCate().getCategoryID();
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
    public ResponseEntity<Book> update(@PathVariable Integer id, @Valid @RequestBody Book pro){
            return ResponseEntity.ok().body(proService.save(pro));
    }

    /**
     * delete program
     * @param id
     */
    @DeleteMapping("/book/{id}")
    public void delete( @Valid @PathVariable Long id){
        proService.deleteById(id);
    }


//    //find by category
//    @GetMapping("/category/book/{id}")
//    public Book getByCate(@PathVariable Integer id){
//        return  proService.findByCateCategoryIDLike(id);
//    }
}
