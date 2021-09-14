package com.example.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "product")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookID;
    @NotNull(message = "Book Name not null")
    private String bookName;
    @NotNull(message = "Actived not null")
    private Boolean actived;
    private String image;


    @JsonIgnore
    @OneToMany(mappedBy = "bookStoreID")
    private List<Store> storeID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cateID")
    private Category cate;

    public Book() {
    }

    public Book(Long bookID, String bookName, Boolean actived, String image, List<Store> storeID, Category cate) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.actived = actived;
        this.image = image;
        this.storeID = storeID;
        this.cate = cate;
    }

    public Long getBookID() {
        return bookID;
    }

    public void setBookID(Long bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Boolean getActived() {
        return actived;
    }

    public void setActived(Boolean actived) {
        this.actived = actived;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Store> getStoreID() {
        return storeID;
    }

    public void setStoreID(List<Store> storeID) {
        this.storeID = storeID;
    }

    public Category getCate() {
        return cate;
    }

    public void setCate(Category cate) {
        this.cate = cate;
    }
}
