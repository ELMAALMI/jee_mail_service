package com.mail.gl.mail_provider.service;

public interface CrudService<T> {
    void create(T o);
    void update(T o);
    void delete(T o);
    T find(long id);
}
