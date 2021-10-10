package com.dev.repositories;

import java.util.List;

public interface CrudRepo<T> {

    // Create
    T add(T t);

    // Read
    T getById(Integer id);

    List<T> getAll();

    // Update
    void update(T t);

    // Delete
    void delete(Integer id);
}
