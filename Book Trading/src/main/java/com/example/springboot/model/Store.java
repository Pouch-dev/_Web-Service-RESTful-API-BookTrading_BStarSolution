package com.example.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store {

    private Integer storeID;
    private AddCustomer store;
    private Store bookStoreID;
}
