package com.vti.repository;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.entity.DetailDepartment;
import com.vti.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.ArrayList;
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

            Criteria cr = session.createCriteria(DetailDepartment.class);
            int offset = (page - 1) * size;
            int limit = size;

            cr.setFirstResult(offset);
            cr.setMaxResults(size);

            List<DetailDepartment> detailDepartments = new ArrayList<>();
            List<DepartmentDTO> departmentDTOS = new ArrayList<>();

            if(nameInput != null && emulationPointInput != null) {
                cr.add(Restrictions.like("name", nameInput));
                cr.add(Restrictions.gt("emulationPoint", emulationPointInput));
                cr.addOrder(Order.asc("name"));
            } else if (nameInput != null && emulationPointInput == null) {
                cr.add(Restrictions.like("name", nameInput));
                cr.addOrder(Order.asc("name"));
                detailDepartments = cr.list();
            } else if (nameInput == null && emulationPointInput != null){
                cr.add(Restrictions.gt("emulationPoint", emulationPointInput));
                cr.addOrder(Order.asc("name"));
                detailDepartments = cr.list();
            } else {
                cr.addOrder(Order.asc("name"));
                detailDepartments = cr.list();
            }

            detailDepartments = cr.list();
            for (DetailDepartment d : detailDepartments) {
                departmentDTOS.add(new DepartmentDTO(d.getId(), d.getName(), d.getAddress().getName()));
            }
            return departmentDTOS;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Long getToTalDepartment(String nameInput, Short emulationPointInput) {

        Session session = null;

        session = hibernateUtils.openSession();

        Criteria cr = session.createCriteria(DetailDepartment.class);

        try {
            if (nameInput != null && emulationPointInput != null) {
                cr.add(Restrictions.like("name", nameInput));
                cr.add(Restrictions.gt("emulationPoint", emulationPointInput));
            } else if (nameInput != null && emulationPointInput == null) {
                cr.add(Restrictions.like("name", nameInput));
            } else if (nameInput == null && emulationPointInput != null) {
                cr.add(Restrictions.gt("emulationPoint", emulationPointInput));
            }

            Long totalResult = ((Number)cr.setProjection(Projections.rowCount()).uniqueResult()).longValue();
            return totalResult;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public DetailDepartment getDepartmentByID(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            Criteria cr = session.createCriteria(DetailDepartment.class);
            cr.add(Restrictions.like("id", id));

            return  (DetailDepartment) cr.uniqueResult();

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

            Criteria cr = session.createCriteria(DetailDepartment.class);
            cr.add(Restrictions.like("name", name));

            return  (DetailDepartment) cr.uniqueResult();

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
