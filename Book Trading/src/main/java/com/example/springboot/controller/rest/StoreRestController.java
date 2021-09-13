//package com.example.springboot.controller.rest;
//
//import com.example.springboot.entity.Store;
//import com.example.springboot.exception.ApiRequestException;
//import com.example.springboot.service.StoreService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/rest")
//public class StoreRestController {
//
//    @Autowired
//    StoreService storeService;
//
//    @GetMapping("/store")
//    public List<Store> getAll(){
//        try {
//            return storeService.findAll();
//        }catch (Exception e){
//            throw new ApiRequestException("Oops can't get all store");
//        }
//    }
//
//    @GetMapping("/store/{id}")
//    public  Store getOne(@PathVariable Integer id){
//        try{
//        return storeService.findById(id);
//        }catch (Exception e){
//            throw new ApiRequestException("Oops can't get one store");
//        }
//    }
//
//    @PostMapping("/store")
//    public Store create(@RequestBody Store store){
//        try{
//        return storeService.save(store);
//        }catch (Exception e){
//            throw new ApiRequestException("Oops can't create store");
//        }
//    }
//
//    @PutMapping("/store/{id}")
//    public Store update(@PathVariable Integer id, @RequestBody Store store){
//        try{
//        return storeService.save(store);
//        }catch (Exception e){
//            throw new ApiRequestException("Oops can't update store");
//        }
//    }
//
//    @DeleteMapping("/store/{id}")
//    public void delete(@PathVariable Integer id){
//        try{
//        storeService.deleteById(id);
//        }catch (Exception e){
//            throw new ApiRequestException("Oops can't delete store");
//        }
//    }
//
//}
