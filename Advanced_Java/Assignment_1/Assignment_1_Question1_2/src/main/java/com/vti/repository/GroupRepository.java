package com.vti.repository;

import com.vti.entity.Group;
import com.vti.utils.HibernateUtils;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class GroupRepository {
    private HibernateUtils hibernateUtils;

    public GroupRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Group> getAllGroups() {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<Group> query = session.createQuery("FROM Group");

            return query.list();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Group getGroupByID(int id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // get group by id
            Group group = session.get(Group.class, id);

            return group;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public Group getGroupByName(String name) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<Group> query = session.createQuery("FROM Group WHERE name = :nameParameter");

            // set parameter
            query.setParameter("nameParameter", name);

            // get result
            Group group = query.uniqueResult();

            return group;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createGroup(Group group) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create
            session.save(group);

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateGroup(int id, String newName, Date createDate) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // get group
            Group group = (Group) session.load(Group.class, id);

            // update
            group.setName(newName);

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateGroup(Group group) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // update
            session.update(group);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deleteGroup(int id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // get group
            Group group = (Group) session.load(Group.class, id);

            // delete
            if (group != null) {
                session.delete(group);
            }

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean isGroupExistsByID(int id) {

        // get group
        Group group = getGroupByID(id);

        // return result
        if (group == null) {
            return false;
        }

        return true;
    }

    public boolean isGroupExistsByName(String name) {
        Group group = getGroupByName(name);

        if (group == null) {
            return false;
        }
        return true;
    }

}


