package com.example.springboot.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ApiMsiConfigId implements Serializable {

    @Column(name = "CONFIG_GROUP")
    private String configGroup;
    @Column(name = "CONFIG_KEY")
    private String configKey;
}
