package com.example.springboot.exception;

import java.util.Map;

public interface ApiMsiException {

    Map<String, String> getConfigGroup(String key);


}
