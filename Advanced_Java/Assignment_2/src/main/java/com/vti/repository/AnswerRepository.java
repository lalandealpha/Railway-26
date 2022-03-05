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

    public Answer getAnswerByID(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // get answer by id
            Answer answer = session.get(Answer.class, id);

            return answer;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    public void createAnswer(Answer answer) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create
            session.save(answer);

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateAnswer(short id, String newContent) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // get answer
            Answer answer = (Answer) session.load(Answer.class, id);

            // update
            answer.setContent(newContent);

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateAnswer(Answer answer) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // update
            session.update(answer);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deleteAnswer(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            session.beginTransaction();

            // get answer
            Answer answer = (Answer) session.load(Answer.class, id);

            // delete
            if (answer != null) {
                session.delete(answer);
            }

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean isAnswerExistsByID(short id) {

        // get answer
        Answer answer = getAnswerByID(id);

        // return result
        if (answer == null) {
            return false;
        }

        return true;
    }
    
}
