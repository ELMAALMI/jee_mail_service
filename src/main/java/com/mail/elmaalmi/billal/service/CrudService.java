package com.mail.elmaalmi.billal.service;

import java.util.List;

public interface CrudService<T> {
    void create(T o) throws Exception;
    void update(T o);
    void delete(T o);
    T find(long id);
    List<T> findAll();
}
