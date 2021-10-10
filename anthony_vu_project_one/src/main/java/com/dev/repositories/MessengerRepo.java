package com.dev.repositories;

import com.dev.models.Message;
import com.dev.models.Messenger;

import java.util.List;

public interface MessengerRepo extends CrudRepo<Messenger> {
    Messenger add(Message message);

    @Override
    Messenger getById(Integer id);

    @Override
    List<Messenger> getAll();

    @Override
    void update(Messenger messenger);

    @Override
    void delete(Integer id);
}
