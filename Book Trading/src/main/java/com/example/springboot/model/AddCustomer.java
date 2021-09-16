package com.example.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomer {

    @NotBlank
    private String username;
    private String password;
    private String fullName;
    private String phoneNumber;
    private String address ;
    private List<Store> userStoreID;


}
