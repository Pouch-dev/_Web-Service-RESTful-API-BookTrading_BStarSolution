package com.example.springboot.entity;

import com.example.springboot.exception.ApiMsiConfigId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ApiConfigException")
public class ApiMsiConfig implements Serializable {

    @EmbeddedId
    private ApiMsiConfigId id;
    @Column(name = "CONFIG_VALUE")
    private String value;
}
