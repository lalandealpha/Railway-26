package com.vti.repository;

import com.vti.entity.Exam;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ExamRepository {
    private HibernateUtils hibernateUtils;

    public ExamRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Exam> getAllExams() {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<Exam> query = session.createQuery("FROM Exam");

            return query.list();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Exam getExamByID(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // get exam by id
            Exam exam = session.get(Exam.class, id);

            return exam;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public Exam getExamByTitle(String title) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<Exam> query = session.createQuery("FROM Exam WHERE title = :titleParameter");

            // set parameter
            query.setParameter("titleParameter", title);

            // get result
            Exam exam = query.uniqueResult();

            return exam;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createExam(Exam exam) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create
            session.save(exam);

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateExam(short id, String newTitle) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // get exam
            Exam exam = (Exam) session.load(Exam.class, id);

            // update
            exam.setTitle(newTitle);

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateExam(Exam exam) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // update
            session.update(exam);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deleteExam(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            session.beginTransaction();

            // get exam
            Exam exam = (Exam) session.load(Exam.class, id);

            // delete
            if (exam != null) {
                session.delete(exam);
            }

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean isExamExistsByID(short id) {

        // get exam
        Exam exam = getExamByID(id);

        // return result
        if (exam == null) {
            return false;
        }

        return true;
    }

    public boolean isExamExistsByTitle(String title) {
        Exam exam = getExamByTitle(title);

        if (exam == null) {
            return false;
        }
        return true;
    }
}
