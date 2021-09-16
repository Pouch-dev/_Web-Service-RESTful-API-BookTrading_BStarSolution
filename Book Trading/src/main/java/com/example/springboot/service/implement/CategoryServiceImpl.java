package com.example.springboot.service.implement;

import com.example.springboot.common.RequestService;
import com.example.springboot.model.AddCategory;
import com.example.springboot.model.UpdateCategory;
import com.example.springboot.repository.CategoryDAO;
import com.example.springboot.entity.Category;
import com.example.springboot.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.springboot.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService  {

    @Autowired
    CategoryDAO cateDAO;

    @Override
    public List<Category> getListCategories() {
        try {
            return cateDAO.findAll();
        }catch (Exception e){
            throw new ApiRequestException("Oops can't get all category");
        }
    }

    @Override
    public Category createCategory(AddCategory categoryDto) {
        cateDAO.findById(categoryDto.getCategoryId()).orElseThrow(() ->
                new ApiRequestException(
                        String.format("Not found Category with id = [%d]", categoryDto.getCategoryId())
                ));
        Category category = new Category();
        category.convertFromAddCategory(categoryDto);
        return cateDAO.save(category);
    }

    @Override
    public Category updateCategory(UpdateCategory updateCategory) {
        Category category = cateDAO.findById(updateCategory.getCategoryID()).orElseThrow(() ->
                new ApiRequestException(String.format(
                        "Not found Category with id = [%d]", updateCategory.getCategoryID())
                ));
        category.setCategoryId(updateCategory.getCategoryID());
        category.setCategoryName(updateCategory.getCategoryName());
        return category;
    }

    @Override
    public Category getCategory(Integer integer) {
        return cateDAO.findById(integer).orElseThrow(() -> new ApiRequestException("Oops can't get one category"));
    }

    @Override
    public void deleteById(Integer integer) {
        try {
            cateDAO.deleteById(integer);
        }catch (Exception e){
            throw new ApiRequestException("Oops can't delete category");
        }
    }
}
