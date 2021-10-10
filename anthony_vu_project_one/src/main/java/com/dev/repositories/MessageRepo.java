package com.dev.repositories;

import com.dev.models.Employee;
import com.dev.models.Message;

import java.util.List;

public interface MessageRepo extends CrudRepo<Message>{

    Message add(Message message);

    @Override
    Message getById(Integer id);

    @Override
    List<Message> getAll();

    @Override
    void update(Message message);

    @Override
    void delete(Integer id);
}
