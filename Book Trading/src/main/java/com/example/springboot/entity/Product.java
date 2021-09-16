package com.example.springboot.entity;

import com.example.springboot.model.AddProduct;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "product")
//@Where(clause = "DELETED_FLAG = '0'")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    @Column(unique = true, nullable = false)
    private String bookName;
    @Column(nullable = false)
    private Boolean isActive;
    private String image;

//    private String deletedFlag = "0";// soft delete


    @JsonIgnore
    @OneToMany(mappedBy = "bookStoreId")
    private List<Store> storeId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cateId")
    private Category cate;

    public Product() {
    }

    public Product(Integer bookId, String bookName, Boolean isActive, String image, List<Store> storeId, Category cate) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.isActive = isActive;
        this.image = image;
        this.storeId = storeId;
        this.cate = cate;
    }

    public Product(Integer bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookID(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Store> getStoreId() {
        return storeId;
    }

    public void setStoreId(List<Store> storeId) {
        this.storeId = storeId;
    }

    public Category getCate() {
        return cate;
    }

    public void setCate(Category cate) {
        this.cate = cate;
    }

    public void convertFromAddBook(AddProduct bookDto) {
        this.bookName = bookDto.getBookName();
        this.isActive = bookDto.getIsActive();
        this.image = bookDto.getBookName();
    }

//    public void setDeletedFlag() {
//        this.deletedFlag = "1";
//    }
}
