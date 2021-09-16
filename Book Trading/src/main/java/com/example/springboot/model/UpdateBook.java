package com.example.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBook {

    @NotBlank
    private Integer bookId;

    private String bookName;

    private String image;

    private Boolean isActive;
}
