package com.vti.repository;

import com.vti.entity.Salary;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class SalaryRepository {
    private HibernateUtils hibernateUtils;

    public SalaryRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Salary> getAllSalaries() {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<Salary> query = session.createQuery("FROM Salary");

            return query.list();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Salary getSalaryByID(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // get salary by id
            Salary salary = session.get(Salary.class, id);

            return salary;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public Salary getSalaryByName(Salary.SalaryName name) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<Salary> query = session.createQuery("FROM Salary WHERE SalaryName = :nameParameter");

            // set parameter
            query.setParameter("nameParameter", name);

            // get result
            Salary salary = query.uniqueResult();

            return salary;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createSalary(Salary salary) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create
            session.save(salary);

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateSalary(short id, Salary.SalaryName newName) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // get salary
            Salary salary = (Salary) session.load(Salary.class, id);

            // update
            salary.setSalaryName(newName);

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateSalary(Salary salary) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // update
            session.update(salary);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deleteSalary(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            session.beginTransaction();

            // get salary
            Salary salary = (Salary) session.load(Salary.class, id);

            // delete
            if (salary != null) {
                session.delete(salary);
            }

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean isSalaryExistsByID(short id) {

        // get salary
        Salary salary = getSalaryByID(id);

        // return result
        if (salary == null) {
            return false;
        }

        return true;
    }

    public boolean isSalaryExistsByName(Salary.SalaryName name) {
        Salary salary = getSalaryByName(name);

        if (salary == null) {
            return false;
        }
        return true;
    }
}
