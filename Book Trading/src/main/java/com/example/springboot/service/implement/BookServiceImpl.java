package com.example.springboot.service.implement;

import com.example.springboot.common.RequestService;
import com.example.springboot.repository.BookDAO;
import com.example.springboot.entity.Book;
import com.example.springboot.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.springboot.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl extends RequestService<Book>  /*implements BookService*/ {

    @Autowired
    BookDAO bookDAO;

    @Override
    public List<Book> findAll() {
        try {
            return bookDAO.findAll();
        }catch (Exception e){
            throw new ApiRequestException("Oops can't get all book");
        }
    }

    @Override
    public <S extends Book> S save(S entity) {
        try {
            return bookDAO.save(entity);
        }catch (Exception e){
            throw new ApiRequestException("Oops can't save book");
        }
    }

    @Override
    public Book findById(Long integer) {
        return bookDAO.findById(integer).orElseThrow(() ->  new ApiRequestException("Oops can't get one book"));
    }

    @Override
    public void deleteById(Long integer) {
        try {
            bookDAO.deleteById(integer);
        }catch (Exception e){
            throw new ApiRequestException("Oops can't delete book");
        }
    }

//    @Override
//    public Book findByCateCategoryIDLike(Integer id) {
//        return bookDAO.findByCateCategoryIDLike(id).orElseThrow(() -> new ApiRequestException("Oops can't get by category book"));
//    }
}
