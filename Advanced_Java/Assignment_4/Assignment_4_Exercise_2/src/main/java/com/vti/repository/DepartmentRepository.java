package com.vti.repository;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.entity.DetailDepartment;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DepartmentRepository {
    private HibernateUtils hibernateUtils;

    public DepartmentRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public void createDepartment(Department department) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            session.beginTransaction();

            // create
            session.save(department);

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public List<DepartmentDTO> getAllDepartments(int page, int size, String nameInput, Short emulationPointInput) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<DepartmentDTO> query;

            if(nameInput != null && emulationPointInput != null) {
                query = session.createQuery(
                        "SELECT new com.vti.dto.DepartmentDTO(d.id, d.name, a.name)" +
                                "FROM DetailDepartment d, Address a " +
                                "WHERE d.id = a.detailDepartment.id AND d.name = :name AND d.emulationPoint > :emulationPoint " +
                                "ORDER BY d.name ASC ");

                query.setParameter("name", nameInput);
                query.setParameter("emulationPoint", emulationPointInput);
            } else if (nameInput != null && emulationPointInput == null) {
                query = session.createQuery(
                        "SELECT new com.vti.dto.DepartmentDTO(d.id, d.name, a.name) " +
                                "FROM DetailDepartment d, Address a " +
                                "WHERE d.id = a.detailDepartment.id AND d.name = :name " +
                                "ORDER BY d.name ASC ");
                query.setParameter("name", nameInput);
            } else if (nameInput == null && emulationPointInput != null){
                query = session.createQuery(
                        "SELECT new com.vti.dto.DepartmentDTO(d.id, d.name, a.name) " +
                                "FROM DetailDepartment d, Address a " +
                                "WHERE d.id = a.detailDepartment.id AND d.emulationPoint > :emulationPoint " +
                                "ORDER BY d.name ASC ");
                query.setParameter("emulationPoint", emulationPointInput);
            } else {
                query = session.createQuery(
                        "SELECT new com.vti.dto.DepartmentDTO(d.id, d.name, a.name) " +
                                "FROM DetailDepartment d, Address a " +
                                "WHERE d.id = a.detailDepartment.id " +
                                "ORDER BY d.name ASC ");
            }

            int offset = (page - 1) * size;
            int limit = size;

            query.setFirstResult(offset);
            query.setMaxResults(limit);

            return query.list();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Long getToTalDepartment(String nameInput, Short emulationPointInput) {

        Session session = null;

        session = hibernateUtils.openSession();

        Query<Long> query;

        if (nameInput != null && emulationPointInput != null) {
            query = session.createQuery("SELECT COUNT(*) FROM DetailDepartment d WHERE d.name = :name AND d.emulationPoint > :emulationPoint");
            query.setParameter("name", nameInput);
            query.setParameter("emulationPoint", emulationPointInput);
        } else if (nameInput != null && emulationPointInput == null) {
            query = session.createQuery("SELECT COUNT(*) FROM DetailDepartment d WHERE d.name = :name");
            query.setParameter("name", nameInput);
        } else if (nameInput == null && emulationPointInput != null) {
            query = session.createQuery("SELECT COUNT(*) FROM DetailDepartment d WHERE d.emulationPoint > :emulationPoint");
            query.setParameter("emulationPoint", emulationPointInput);
        } else {
            query = session.createQuery("SELECT COUNT(*) FROM DetailDepartment");
        }

        return query.uniqueResult();

    }

    public DetailDepartment getDepartmentByID(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // get account by id
            Query<DetailDepartment> query = session.createQuery("FROM DetailDepartment d WHERE d.id = :id");
            query.setParameter("id", id);

            return query.uniqueResult();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public DetailDepartment getDepartmentByName(String name) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // get account by id
            Query<DetailDepartment> query = session.createQuery("FROM DetailDepartment d WHERE d.name = :name");

            query.setParameter("name", name);

            return query.uniqueResult();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateDepartment(short id, String newName) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            session.beginTransaction();

            // update Department
            Query query = session.createQuery("UPDATE Department d SET d.name = :name WHERE d.id = :id");

            query.setParameter("name", newName);
            query.setParameter("id", id);

            query.executeUpdate();

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deleteDepartment(List<Short> ids) {
        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            session.beginTransaction();

            for (Short id : ids) {
                Query query = session.createQuery("DELETE FROM Department d WHERE d.id = :id");

                query.setParameter("id", id);

                query.executeUpdate();
            }

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean isDepartmentExistsById(short id) {
        DetailDepartment detailDepartment = getDepartmentByID(id);
        if (detailDepartment != null) {
            return true;
        }
        return false;
    }

    public boolean isDepartmentExistsByName(String name) {
        DetailDepartment detailDepartment = getDepartmentByName(name);
        if (detailDepartment != null) {
            return true;
        }
        return false;
    }
}
