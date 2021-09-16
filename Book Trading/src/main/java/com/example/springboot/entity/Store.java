package com.example.springboot.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "store")
public class Store implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer storeId;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userStoreId")
    private Customer store;

    @ManyToOne
    @JoinColumn(name = "bookId")
    private Product bookStoreId;

    public Store() {
    }

    public Store(Integer storeId, Customer store, Product bookStoreId) {
        this.storeId = storeId;
        this.store = store;
        this.bookStoreId = bookStoreId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Customer getStore() {
        return store;
    }

    public void setStore(Customer store) {
        this.store = store;
    }

    public Product getBookStoreId() {
        return bookStoreId;
    }

    public void setBookStoreId(Product bookStoreId) {
        this.bookStoreId = bookStoreId;
    }
}
