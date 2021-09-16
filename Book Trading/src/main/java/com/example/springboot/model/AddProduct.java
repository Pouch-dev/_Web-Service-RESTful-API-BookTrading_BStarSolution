package com.example.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProduct {

    @NotBlank
    private String bookName;
    private Boolean isActive;
    private String image;
    private List<Store> storeId;
    @NotNull
    private Integer categoryId;
}
