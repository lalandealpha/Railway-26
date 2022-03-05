package com.vti.repository;

import com.vti.entity.Address;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AddressRepository {
    private HibernateUtils hibernateUtils;

    public AddressRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Address> getAllAddresss() {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<Address> query = session.createQuery("FROM Address");

            return query.list();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
