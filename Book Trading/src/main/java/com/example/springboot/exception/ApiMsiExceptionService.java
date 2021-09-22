package com.example.springboot.exception;

import com.example.springboot.entity.ApiMsiConfig;
import com.example.springboot.repository.ApiExceptionReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ApiMsiExceptionService implements ApiMsiException{

    @Autowired ApiExceptionReponsitory exceptionReponsitory;



    @Override
    public Map<String, String> getConfigGroup(String key) {
        try{
            if(key == null){ return null; }
            HashMap<String, String> configGroup = new HashMap<>();
            List<ApiMsiConfig> configList = exceptionReponsitory.findAllById_ConfigGroup(key);
            if(configList == null || configList.isEmpty()) return null;
            for(ApiMsiConfig c : configList){
                configGroup.put(c.getId().getConfigKey(), c.getValue());
            }
            return configGroup;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
