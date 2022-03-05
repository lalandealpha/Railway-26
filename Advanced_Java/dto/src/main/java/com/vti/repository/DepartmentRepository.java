package com.vti.repository;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DepartmentRepository {
    private HibernateUtils hibernateUtils;

    public DepartmentRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Department> getAllDepartments(int i) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<Department> query = session.createQuery("FROM Department");

            return query.list();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createDepartment(Department department) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create
            session.save(department);

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Department getDepartmentByID(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // get account by id
            Department department = session.get(Department.class, id);

            return department;

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
                        "SELECT new com.vti.dto.DepartmentDTO(d.id, d.name, a.name, d.accounts.length())" +
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

}
