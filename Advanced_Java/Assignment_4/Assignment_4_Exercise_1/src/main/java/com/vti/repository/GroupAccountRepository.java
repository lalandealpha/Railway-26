package com.vti.repository;

import com.vti.entity.GroupAccount;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class GroupAccountRepository {
    private HibernateUtils hibernateUtils;

    public GroupAccountRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<GroupAccount> getAllGroupAccounts() {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<GroupAccount> query = session.createQuery("FROM GroupAccount");

            return query.list();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public GroupAccount getGroupAccountByID(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // get group by id
            GroupAccount groupAccount = session.get(GroupAccount.class, id);

            return groupAccount;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

//    @SuppressWarnings("unchecked")
//    public GroupAccount getGroupAccountByName(String username) {
//
//        Session session = null;
//
//        try {
//
//            // get session
//            session = hibernateUtils.openSession();
//
//            // create hql query
//            Query<GroupAccount> query = session.createQuery("FROM GroupAccount WHERE username = :nameParameter");
//
//            // set parameter
//            query.setParameter("nameParameter", username);
//
//            // get result
//            GroupAccount group = query.uniqueResult();
//
//            return group;
//
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//    }

    public void createGroupAccount(GroupAccount groupAccount) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            session.beginTransaction();

            // create
            session.save(groupAccount);

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

//    public void updateGroupAccount(short id, String newUsername) {
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
//            GroupAccount group = (GroupAccount) session.load(GroupAccount.class, id);
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

    public void updateGroupAccount(GroupAccount group) {

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

    public void deleteGroupAccount(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            session.beginTransaction();

            // get group
            GroupAccount group = (GroupAccount) session.load(GroupAccount.class, id);

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

    public boolean isGroupAccountExistsByID(short id) {

        // get group
        GroupAccount group = getGroupAccountByID(id);

        // return result
        if (group == null) {
            return false;
        }

        return true;
    }

//    public boolean isGroupAccountExistsByName(String name) {
//        GroupAccount group = getGroupAccountByName(name);
//
//        if (group == null) {
//            return false;
//        }
//        return true;
//    }
}
