package com.vti.repository;

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

    public Position getPositionByID(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // get position by id
            Position position = session.get(Position.class, id);

            return position;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public Position getPositionByName(String name) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<Position> query = session.createQuery("FROM Position WHERE name = :nameParameter");

            // set parameter
            query.setParameter("nameParameter", name);

            // get result
            Position position = query.uniqueResult();

            return position;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createPosition(Position position) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create
            session.save(position);

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updatePosition(short id, String newName) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // get position
            Position position = (Position) session.load(Position.class, id);

            // update
            position.setName(newName);

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updatePosition(Position position) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // update
            session.update(position);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deletePosition(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            session.beginTransaction();

            // get position
            Position position = (Position) session.load(Position.class, id);

            // delete
            if (position != null) {
                session.delete(position);
            }

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean isPositionExistsByID(short id) {

        // get position
        Position position = getPositionByID(id);

        // return result
        if (position == null) {
            return false;
        }

        return true;
    }

    public boolean isPositionExistsByName(String name) {
        Position position = getPositionByName(name);

        if (position == null) {
            return false;
        }
        return true;
    }
}
