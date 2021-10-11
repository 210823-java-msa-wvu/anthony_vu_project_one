package com.dev.repositories.hibernate;

import com.dev.models.Application;
import com.dev.models.Employee;
import com.dev.repositories.UserRepo;
import com.dev.utilis.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class UserHibernate implements UserRepo {
    @Override
    public Employee add(Employee employee) {
        return null;
    }

    @Override
    public Employee getById(Integer id) {
        Session s = HibernateUtil.getSession();
        Employee e = s.get(Employee.class, id);
        s.close();

        return e;
    }

    @Override
    public Employee getByName(String eid) {

        Session s = HibernateUtil.getSession();
        String query = "from employees where eid = :eid";
        Query<Employee> q = s.createQuery(query, Employee.class);
        q.setParameter("eid", eid);
        Employee e = q.getSingleResult();
        s.close();

        return e;
    }

    @Override
    public List<Employee> getAll() {

        Session s = HibernateUtil.getSession();

        String query = "from employees";
        Query<Employee> q = s.createQuery(query,Employee.class);

        List<Employee> e = q.getResultList();
        s.close();

        return e;
    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void delete(Integer id) {

    }
}
