package com.example.springboot.common;

import java.util.List;

public abstract class RequestService <k>{

    public abstract List<k> findAll();

    public abstract <S extends k> S save(S entity);

    public abstract k findById(Long integer);

    public abstract void deleteById(Long integer);
}
