package com.dev.repositories.hibernate;

import com.dev.models.Application;
import com.dev.models.Employee;
import com.dev.repositories.ApplyRepo;
import com.dev.utilis.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class ApplyHibernate implements ApplyRepo<Application> {

    private Logger log = LogManager.getLogger(Application.class);

    @Override
    public Employee add(Employee employee) {
        return null;
    }

    @Override
    public Application add(Application application) {

        Session s = HibernateUtil.getSession();

        // I'm going to use a try catch finally to make sure that our transaction only commits to the database
        // so long as there are no exceptions thrown.

        Transaction tx = null;

        try {
            tx = s.beginTransaction();
            s.save(application);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if (tx != null)
                tx.rollback();
        } finally {
            s.close();
        }
        return application;
    }

    @Override
    public Application getById(Integer id) {
        return null;
    }

    @Override
    public List<Application> getAll() {
        Session s = HibernateUtil.getSession();

        String query = "from application";
        Query<Application> q = s.createQuery(query,Application.class);

        List<Application> a = q.getResultList();
        s.close();

        return a;
    }

    public void updateDecision(String eid, String choice, Integer depart){
        try (Session s = HibernateUtil.getSession()){

            Query q = s.createQuery("update Applications set admin1 = :approve" + " where eid = :eid AND depart = :depart");
            System.out.println("Got to Query");
            q.setParameter("approve", choice);
            q.setParameter("eid", eid);
            q.setParameter("depart", depart);

            Integer result = q.executeUpdate();

        } catch (HibernateException e){
            log.error(e.getMessage());
        }

    }

    @Override
    public void update(Application application) {

    }

    @Override
    public void delete(Integer id) {

    }
}
