package com.severstal.infocom.qualificationtest.service;

import java.util.List;

public interface ICrudService<T> {
    T create(T t);

    T get(Long id);

    List<T> getAll();

    T update(T t);

    void delete(T t);

    void delete(Long id);

    void deleteAll(List<Long> ids);
}
