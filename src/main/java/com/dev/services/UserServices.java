package com.dev.services;

import com.dev.models.Application;
import com.dev.models.Employee;
import com.dev.repositories.UserRepo;
import com.dev.repositories.hibernate.ApplyHibernate;
import com.dev.repositories.hibernate.UserHibernate;
import org.apache.catalina.User;

import java.util.List;

public class UserServices {

    UserHibernate userRepo = new UserHibernate();
    public ApplyHibernate applyHibernate = new ApplyHibernate();

    public Employee login(String name, String eid){

        Employee e = userRepo.getByName(eid);

        if (e != null) {
            if (name.equals(e.getLastname()) && eid.equals(e.getEid())){
                return e;
            }
            // now check to make sure it matches
            //return name.equals(e.getLastname()) && eid.equals(e.getEid());
        }
        return null;
    }

    public List<Application> getAllApps() {
        return applyHibernate.getAll();
    }
}
