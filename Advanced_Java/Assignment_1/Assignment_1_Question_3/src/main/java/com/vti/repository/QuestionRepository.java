package com.vti.repository;

import com.vti.entity.Question;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class QuestionRepository {
    private HibernateUtils hibernateUtils;

    public QuestionRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Question> getAllQuestions() {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<Question> query = session.createQuery("FROM Question");

            return query.list();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Question getQuestionByID(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // get question by id
            Question question = session.get(Question.class, id);

            return question;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    public void createQuestion(Question question) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create
            session.save(question);

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateQuestion(short id, String newContent) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // get question
            Question question = (Question) session.load(Question.class, id);

            // update
            question.setContent(newContent);

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateQuestion(Question question) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // update
            session.update(question);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deleteQuestion(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            session.beginTransaction();

            // get question
            Question question = (Question) session.load(Question.class, id);

            // delete
            if (question != null) {
                session.delete(question);
            }

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean isQuestionExistsByID(short id) {

        // get question
        Question question = getQuestionByID(id);

        // return result
        if (question == null) {
            return false;
        }

        return true;
    }

}
