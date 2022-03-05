package com.vti.repository;

import com.vti.entity.TypeQuestion;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TypeQuestionRepository {
    private HibernateUtils hibernateUtils;

    public TypeQuestionRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<TypeQuestion> getAllTypeQuestions() {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<TypeQuestion> query = session.createQuery("FROM TypeQuestion");

            return query.list();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
