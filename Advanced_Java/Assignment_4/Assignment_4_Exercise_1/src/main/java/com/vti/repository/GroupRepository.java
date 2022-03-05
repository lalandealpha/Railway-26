package com.vti.repository;

import com.vti.entity.Group;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

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

    public Group getGroupByID(short id) {

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

//    @SuppressWarnings("unchecked")
//    public Group getGroupByName(String username) {
//
//        Session session = null;
//
//        try {
//
//            // get session
//            session = hibernateUtils.openSession();
//
//            // create hql query
//            Query<Group> query = session.createQuery("FROM Group WHERE username = :nameParameter");
//
//            // set parameter
//            query.setParameter("nameParameter", username);
//
//            // get result
//            Group group = query.uniqueResult();
//
//            return group;
//
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//    }

    public Group createGroup(Group group) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            session.beginTransaction();

            // create
           Short id = (Short) session.save(group);

           session.getTransaction().commit();

            return getGroupByID(id);

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

//    public void updateGroup(short id, String newUsername) {
//
//        Session session = null;
//
//        try {
//
//            // get session
//            session = hibernateUtils.openSession();
//            session.beginTransaction();
//
//            // get group
//            Group group = (Group) session.load(Group.class, id);
//
//            // update
//            group.setUsername(newUsername);
//
//            session.getTransaction().commit();
//
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//    }

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

    public void deleteGroup(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            session.beginTransaction();

            // get group
            Group group = (Group) session.load(Group.class, id);

            // delete
            if (group != null) {
                session.delete(group);
            }

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean isGroupExistsByID(short id) {

        // get group
        Group group = getGroupByID(id);

        // return result
        if (group == null) {
            return false;
        }

        return true;
    }

//    public boolean isGroupExistsByName(String name) {
//        Group group = getGroupByName(name);
//
//        if (group == null) {
//            return false;
//        }
//        return true;
//    }
}
