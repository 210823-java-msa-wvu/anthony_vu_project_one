package com.dev.repositories.hibernate;

import com.dev.models.Employee;
import com.dev.models.Message;
import com.dev.models.Messenger;
import com.dev.repositories.MessengerRepo;
import com.dev.utilis.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class MessengerHibernate implements MessengerRepo {

    @Override
    public Messenger add(Messenger messenger) {
        return null;
    }

    @Override
    public Messenger add(Message message) {
        return null;
    }

    @Override
    public Messenger getById(Integer id) {
        return null;
    }

    @Override
    public List<Messenger> getAll() {
        Session s = HibernateUtil.getSession();

        String query = "from messager";
        Query<Messenger> q = s.createQuery(query,Messenger.class);

        List<Messenger> m = q.getResultList();
        s.close();

        return m;
    }

    @Override
    public void update(Messenger messenger) {

    }

    @Override
    public void delete(Integer id) {

    }
}
