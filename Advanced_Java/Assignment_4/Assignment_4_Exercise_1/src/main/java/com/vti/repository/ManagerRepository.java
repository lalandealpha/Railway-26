package com.vti.repository;

import com.vti.entity.Manager;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ManagerRepository {
    private HibernateUtils hibernateUtils;

    public ManagerRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Manager> getAllManagers() {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<Manager> query = session.createQuery("FROM Manager");

            return query.list();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Manager getManagerByID(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // get manager by id
            Manager manager = session.get(Manager.class, id);

            return manager;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

//    @SuppressWarnings("unchecked")
//    public Manager getManagerByName(String username) {
//
//        Session session = null;
//
//        try {
//
//            // get session
//            session = hibernateUtils.openSession();
//
//            // create hql query
//            Query<Manager> query = session.createQuery("FROM Manager WHERE username = :nameParameter");
//
//            // set parameter
//            query.setParameter("nameParameter", username);
//
//            // get result
//            Manager manager = query.uniqueResult();
//
//            return manager;
//
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//    }

    public Manager createManager(Manager manager) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            session.beginTransaction();

            // create
            Short id = (Short) session.save(manager);

            session.getTransaction().commit();

            return getManagerByID(id);


        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

//    public void updateManager(short id, String newUsername) {
//
//        Session session = null;
//
//        try {
//
//            // get session
//            session = hibernateUtils.openSession();
//            session.beginTransaction();
//
//            // get manager
//            Manager manager = (Manager) session.load(Manager.class, id);
//
//            // update
//            manager.setUsername(newUsername);
//
//            session.getTransaction().commit();
//
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//    }

    public void updateManager(Manager manager) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // update
            session.update(manager);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deleteManager(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            session.beginTransaction();

            // get manager
            Manager manager = (Manager) session.load(Manager.class, id);

            // delete
            if (manager != null) {
                session.delete(manager);
            }

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean isManagerExistsByID(short id) {

        // get manager
        Manager manager = getManagerByID(id);

        // return result
        if (manager == null) {
            return false;
        }

        return true;
    }

//    public boolean isManagerExistsByName(String name) {
//        Manager manager = getManagerByName(name);
//
//        if (manager == null) {
//            return false;
//        }
//        return true;
//    }
}
