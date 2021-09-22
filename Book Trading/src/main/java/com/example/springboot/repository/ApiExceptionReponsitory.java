package com.example.springboot.repository;


import com.example.springboot.entity.ApiMsiConfig;
import com.example.springboot.exception.ApiMsiConfigId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApiExceptionReponsitory extends JpaRepository<ApiMsiConfig, ApiMsiConfigId> {

        List<ApiMsiConfig> findAllById_ConfigGroup(String key);
}
