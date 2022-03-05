package com.vti.repository;

import com.vti.entity.Answer;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AnswerRepository {
    private HibernateUtils hibernateUtils;

    public AnswerRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Answer> getAllAnswers() {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<Answer> query = session.createQuery("FROM Answer");

            return query.list();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
