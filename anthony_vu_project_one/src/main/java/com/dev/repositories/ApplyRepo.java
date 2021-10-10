package com.dev.repositories;

import com.dev.models.Application;
import com.dev.models.Employee;

import java.util.List;

public interface ApplyRepo<A> extends CrudRepo<Application>{

    Employee add(Employee employee);

    @Override
    Application getById(Integer id);

    @Override
    List<Application> getAll();

    @Override
    void update(Application application);

    @Override
    void delete(Integer id);
}
