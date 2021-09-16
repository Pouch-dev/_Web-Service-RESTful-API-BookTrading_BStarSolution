package com.example.springboot.entity;

import com.example.springboot.model.AddCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "category")
public class Category implements Serializable {

    @Id
    @NotNull(message = "Category ID not empty")
    private Integer categoryId;  // categoryId != null
    @NotEmpty(message = "Category Name not null")
    // @NotBlank
    private String categoryName; // categoryName !=null && categoryName.trim().length() > 0

    @JsonIgnore
    @OneToMany(mappedBy = "cate")
    private List<Product> cateId;

    public Category() {
    }

    public Category(Integer categoryId, String categoryName, List<Product> cateId) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.cateId = cateId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getCateId() {
        return cateId;
    }

    public void setCateId(List<Product> cateId) {
        this.cateId = cateId;
    }

    public void  convertFromAddCategory(AddCategory categoryDto){
        this.categoryId = categoryDto.getCategoryId();
        this.categoryName = categoryDto.getCategoryName();
    }
}
