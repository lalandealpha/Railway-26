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

    public void createExam(Exam exam) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            session.beginTransaction();

            // create
            session.save(exam);

            session.getTransaction().commit();

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

            // get question by id
            Exam exam = session.get(Exam.class, id);

            return exam;

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
}
