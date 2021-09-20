package com.example.springboot.controller.rest;

import com.example.springboot.service.ClientService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ClientService clientService;
    @GetMapping
    public ResponseEntity<Object> doTestCallRest() throws Exception{
        return ResponseEntity.ok().body(clientService.callService());
    }

}
