package com.example.springboot.service;

import com.example.springboot.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@EnableScheduling
@Configuration
@RequestMapping("cronJob")
public class CronJobService {

    @Autowired
    BookService bookService;

    @Scheduled(fixedDelay = 30000)
    @GetMapping
    public void cronJobRun(){
        List<Product> list = new ArrayList<Product>();

        list = bookService.findAll();

        for(Product b:list){
            System.out.println(b.getBookId()+" | "+
                                b.getBookName()+" | "+
                                b.getCate().getCategoryName()+" | "+
                                b.getIsActive()+" | "+
                                b.getImage());
            System.out.println("-----------------------------------------");
        }
        System.out.println("Fixed delay task - " + System.currentTimeMillis() / 5000);
    }
}
