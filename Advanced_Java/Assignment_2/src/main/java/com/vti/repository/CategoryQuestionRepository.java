package com.vti.repository;

import com.vti.entity.CategoryQuestion;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CategoryQuestionRepository {
    private HibernateUtils hibernateUtils;

    public CategoryQuestionRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<CategoryQuestion> getAllCategoryQuestions() {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<CategoryQuestion> query = session.createQuery("FROM CategoryQuestion");

            return query.list();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public CategoryQuestion getCategoryQuestionByID(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // get categoryQuestion by id
            CategoryQuestion categoryQuestion = session.get(CategoryQuestion.class, id);

            return categoryQuestion;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public CategoryQuestion getCategoryQuestionByName(String name) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<CategoryQuestion> query = session.createQuery("FROM CategoryQuestion WHERE name = :nameParameter");

            // set parameter
            query.setParameter("nameParameter", name);

            // get result
            CategoryQuestion categoryQuestion = query.uniqueResult();

            return categoryQuestion;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createCategoryQuestion(CategoryQuestion categoryQuestion) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create
            session.save(categoryQuestion);

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateCategoryQuestion(short id, String newName) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // get categoryQuestion
            CategoryQuestion categoryQuestion = (CategoryQuestion) session.load(CategoryQuestion.class, id);

            // update
            categoryQuestion.setName(newName);

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateCategoryQuestion(CategoryQuestion categoryQuestion) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // update
            session.update(categoryQuestion);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deleteCategoryQuestion(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            session.beginTransaction();

            // get categoryQuestion
            CategoryQuestion categoryQuestion = (CategoryQuestion) session.load(CategoryQuestion.class, id);

            // delete
            if (categoryQuestion != null) {
                session.delete(categoryQuestion);
            }

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean isCategoryQuestionExistsByID(short id) {

        // get categoryQuestion
        CategoryQuestion categoryQuestion = getCategoryQuestionByID(id);

        // return result
        if (categoryQuestion == null) {
            return false;
        }

        return true;
    }

    public boolean isCategoryQuestionExistsByName(String name) {
        CategoryQuestion categoryQuestion = getCategoryQuestionByName(name);

        if (categoryQuestion == null) {
            return false;
        }
        return true;
    }
}
