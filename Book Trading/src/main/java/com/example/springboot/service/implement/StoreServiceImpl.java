package com.example.springboot.service.implement;

import com.example.springboot.common.RequestService;
import com.example.springboot.exception.ApiRequestException;
import com.example.springboot.repository.StoreDAO;
import com.example.springboot.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Service
public class StoreServiceImpl extends RequestService<Store>  /*implements StoreService*/ {

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
    public <S extends Store> S save(S entity) {
        try{
            return storeDAO.save(entity);
        }catch (Exception e){
            throw new ApiRequestException("Oops can't save store");
        }
    }

    @Override
    public Store findById(Long integer) {
            return storeDAO.findById(integer).orElseThrow(() -> new ApiRequestException("Oops can't get one store"));
    }

    @Override
    public void deleteById(Long integer) {
        try{
            storeDAO.deleteById(integer);
        }catch (Exception e){
            throw new ApiRequestException("Oops can't delete store");
        }
    }
}
