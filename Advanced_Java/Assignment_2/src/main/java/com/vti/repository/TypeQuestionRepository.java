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

    public TypeQuestion getTypeQuestionByID(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // get typeQuestion by id
            TypeQuestion typeQuestion = session.get(TypeQuestion.class, id);

            return typeQuestion;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public TypeQuestion getTypeQuestionByName(String name) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<TypeQuestion> query = session.createQuery("FROM TypeQuestion WHERE name = :nameParameter");

            // set parameter
            query.setParameter("nameParameter", name);

            // get result
            TypeQuestion typeQuestion = query.uniqueResult();

            return typeQuestion;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createTypeQuestion(TypeQuestion typeQuestion) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create
            session.save(typeQuestion);

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateTypeQuestion(short id, TypeQuestion.TypeName newName) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // get typeQuestion
            TypeQuestion typeQuestion = (TypeQuestion) session.load(TypeQuestion.class, id);

            // update
            typeQuestion.setName(newName);

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateTypeQuestion(TypeQuestion typeQuestion) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // update
            session.update(typeQuestion);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deleteTypeQuestion(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            session.beginTransaction();

            // get typeQuestion
            TypeQuestion typeQuestion = (TypeQuestion) session.load(TypeQuestion.class, id);

            // delete
            if (typeQuestion != null) {
                session.delete(typeQuestion);
            }

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean isTypeQuestionExistsByID(short id) {

        // get typeQuestion
        TypeQuestion typeQuestion = getTypeQuestionByID(id);

        // return result
        if (typeQuestion == null) {
            return false;
        }

        return true;
    }

    public boolean isTypeQuestionExistsByName(String name) {
        TypeQuestion typeQuestion = getTypeQuestionByName(name);

        if (typeQuestion == null) {
            return false;
        }
        return true;
    }
}
