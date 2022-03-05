package com.vti.repository;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.DetailDepartment;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DetailDepartmentRepository {
    private HibernateUtils hibernateUtils;

    public DetailDepartmentRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<DetailDepartment> getAllDetailDepartments() {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<DetailDepartment> query = session.createQuery("FROM DetailDepartment");

            return query.list();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public DetailDepartment getDetailDepartmentByID(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // get account by id
            DetailDepartment detailDepartment = session.get(DetailDepartment.class, id);

            return detailDepartment;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createDetailDepartment(DetailDepartment detailDepartment) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create
            session.save(detailDepartment);

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
