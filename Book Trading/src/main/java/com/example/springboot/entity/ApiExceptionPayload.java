package com.example.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ApiExceptionPayload")
@AllArgsConstructor
@NoArgsConstructor
public class ApiExceptionPayload implements Serializable {

    @Id
    private int errorCode;
    private String httpStatus;
    private String message;
    private String timestamp;
}
