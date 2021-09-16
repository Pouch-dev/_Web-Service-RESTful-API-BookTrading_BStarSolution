package com.example.springboot.model;

import com.example.springboot.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCategory {

    @NotBlank
    private Integer categoryId;
    private String categoryName;
    private List<Product> cateId;
}
