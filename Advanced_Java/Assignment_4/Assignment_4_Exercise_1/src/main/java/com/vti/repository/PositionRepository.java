package com.vti.repository;

import com.vti.entity.Account;
import com.vti.entity.Position;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PositionRepository {
    private HibernateUtils hibernateUtils;

    public PositionRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Position> getAllPositions() {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<Position> query = session.createQuery("FROM Position");

            return query.list();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
