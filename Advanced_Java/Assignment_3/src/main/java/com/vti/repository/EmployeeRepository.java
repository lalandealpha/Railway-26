package com.vti.repository;

import com.vti.entity.Employee;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeRepository {
    private HibernateUtils hibernateUtils;

    public EmployeeRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Employee> getAllEmployees() {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<Employee> query = session.createQuery("FROM Employee");

            return query.list();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Employee getEmployeeByID(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // get employee by id
            Employee employee = session.get(Employee.class, id);

            return employee;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

//    @SuppressWarnings("unchecked")
//    public Employee getEmployeeByName(String username) {
//
//        Session session = null;
//
//        try {
//
//            // get session
//            session = hibernateUtils.openSession();
//
//            // create hql query
//            Query<Employee> query = session.createQuery("FROM Employee WHERE username = :nameParameter");
//
//            // set parameter
//            query.setParameter("nameParameter", username);
//
//            // get result
//            Employee employee = query.uniqueResult();
//
//            return employee;
//
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//    }

    public Employee createEmployee(Employee employee) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            session.beginTransaction();

            // create
            Short id = (Short) session.save(employee);

            session.getTransaction().commit();

            return getEmployeeByID(id);


        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

//    public void updateEmployee(short id, String newUsername) {
//
//        Session session = null;
//
//        try {
//
//            // get session
//            session = hibernateUtils.openSession();
//            session.beginTransaction();
//
//            // get employee
//            Employee employee = (Employee) session.load(Employee.class, id);
//
//            // update
//            employee.setUsername(newUsername);
//
//            session.getTransaction().commit();
//
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//    }

    public void updateEmployee(Employee employee) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // update
            session.update(employee);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deleteEmployee(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            session.beginTransaction();

            // get employee
            Employee employee = (Employee) session.load(Employee.class, id);

            // delete
            if (employee != null) {
                session.delete(employee);
            }

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean isEmployeeExistsByID(short id) {

        // get employee
        Employee employee = getEmployeeByID(id);

        // return result
        if (employee == null) {
            return false;
        }

        return true;
    }

//    public boolean isEmployeeExistsByName(String name) {
//        Employee employee = getEmployeeByName(name);
//
//        if (employee == null) {
//            return false;
//        }
//        return true;
//    }
}
