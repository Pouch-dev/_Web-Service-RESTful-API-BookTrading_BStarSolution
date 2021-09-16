package com.example.springboot.entity;

import com.example.springboot.model.AddCustomer;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Username not null")
    @Size(min = 6, max = 12, message = "Username must be between 6 and 12 characters")
    private String username;
    @NotEmpty(message = "Password not null")
    @Size(min = 6, max = 12, message = "Password must be between 6 and 12 characters")
    private String password;
    private String fullName;
    private String phoneNumber;
    @NotEmpty(message = "Email not null")// các annotation đưa qua model
    private String address ;

    @JsonIgnore
    @OneToMany(mappedBy = "store")
    private List<Store> userStoreId;

    public Customer() {
    }

    public Customer(Integer id, String username, String password, String fullName, String phoneNumber, String address, List<Store> userStoreId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.userStoreId = userStoreId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Store> getUserStoreId() {
        return userStoreId;
    }

    public void setUserStoreId(List<Store> userStoreId) {
        this.userStoreId = userStoreId;
    }

    public void convertFromAddCustomer(AddCustomer customerDto){
        this.username = customerDto.getUsername();
        this.password = customerDto.getPassword();
        this.fullName = customerDto.getFullName();
        this.phoneNumber = customerDto.getPhoneNumber();
        this.address = customerDto.getAddress();
    }

}
