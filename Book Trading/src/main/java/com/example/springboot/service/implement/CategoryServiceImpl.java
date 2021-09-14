package com.example.springboot.service.implement;

import com.example.springboot.common.RequestService;
import com.example.springboot.repository.CategoryDAO;
import com.example.springboot.entity.Category;
import com.example.springboot.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.springboot.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl extends RequestService<Category>  {

    @Autowired
    CategoryDAO cateDAO;

    @Override
    public List<Category> findAll() {
        try {
            return cateDAO.findAll();
        }catch (Exception e){
            throw new ApiRequestException("Oops can't get all category");
        }
    }

    @Override
    public <S extends Category> S save(S entity) {
        try {
            return cateDAO.save(entity);
        }catch (Exception e){
            throw new ApiRequestException("Oops can't save category");
        }
    }

    @Override
    public Category findById(Long integer) {
        return cateDAO.findById(integer).orElseThrow(() -> new ApiRequestException("Oops can't get one category"));
    }

    @Override
    public void deleteById(Long integer) {
        try {
            cateDAO.deleteById(integer);
        }catch (Exception e){
            throw new ApiRequestException("Oops can't delete category");
        }
    }
}
