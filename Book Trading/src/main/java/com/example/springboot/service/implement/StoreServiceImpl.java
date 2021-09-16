package com.example.springboot.service.implement;

import com.example.springboot.common.RequestService;
import com.example.springboot.exception.ApiRequestException;
import com.example.springboot.repository.StoreDAO;
import com.example.springboot.entity.Store;
import com.example.springboot.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl extends RequestService<Store> implements StoreService {

    @Autowired
    StoreDAO storeDAO;

    @Override
    public List<Store> findAll() {
        try {
            return storeDAO.findAll();
        }catch (Exception e){
            throw new ApiRequestException("Oops can't get all store");
        }
    }

    @Override
    public Store save(Store store) {
        try{
            return storeDAO.save(store);
        }catch (Exception e){
            throw new ApiRequestException("Oops can't save store");
        }
    }

    @Override
    public Store findById(Integer integer) {
            return storeDAO.findById(integer).orElseThrow(() -> new ApiRequestException("Oops can't get one store"));
    }

    @Override
    public void deleteById(Integer integer) {
        try{
            storeDAO.deleteById(integer);
        }catch (Exception e){
            throw new ApiRequestException("Oops can't delete store");
        }
    }
}
