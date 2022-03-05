package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.vti.entity.Group;
import com.vti.utils.HibernateUtils;

@Repository
public class GroupRepository implements IGroupRepository {

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

            // get Group by id
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
            session.beginTransaction();

            // create
            session.save(group);

            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateGroup(int id, String newName) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // get Group
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
            session.beginTransaction();

            // get Group
            Group group = (Group) session.load(Group.class, id);

            // delete
            session.delete(group);

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean isGroupExistsByID(int id) {

        // get Group
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
