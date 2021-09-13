//package com.example.springboot.service.implement;
//
//import com.example.springboot.dao.StoreDAO;
//import com.example.springboot.entity.Store;
//import com.example.springboot.service.StoreService;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//public class StoreServiceImpl implements StoreService {
//
//    @Autowired
//    StoreDAO storeDAO;
//
//    @Override
//    public List<Store> findAll() {
//        return storeDAO.findAll();
//    }
//
//    @Override
//    public <S extends Store> S save(S entity) {
//        return storeDAO.save(entity);
//    }
//
//    @Override
//    public Store findById(Integer integer) {
//        return storeDAO.findById(integer).get();
//    }
//
//    @Override
//    public void deleteById(Integer integer) {
//        storeDAO.deleteById(integer);
//    }
//}
