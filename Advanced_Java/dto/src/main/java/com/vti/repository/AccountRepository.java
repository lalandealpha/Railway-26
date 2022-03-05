package com.vti.repository;

import com.vti.entity.Account;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AccountRepository {
    private HibernateUtils hibernateUtils;

    public AccountRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Account> getAllAccounts() {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<Account> query = session.createQuery("FROM Account");

            return query.list();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Account getAccountByID(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // get account by id
            Account account = session.get(Account.class, id);

            return account;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

//    @SuppressWarnings("unchecked")
//    public Account getAccountByName(String username) {
//
//        Session session = null;
//
//        try {
//
//            // get session
//            session = hibernateUtils.openSession();
//
//            // create hql query
//            Query<Account> query = session.createQuery("FROM Account WHERE username = :nameParameter");
//
//            // set parameter
//            query.setParameter("nameParameter", username);
//
//            // get result
//            Account account = query.uniqueResult();
//
//            return account;
//
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//    }

    public Account createAccount(Account account) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            session.beginTransaction();

            // create
            Short id = (Short) session.save(account);

            session.getTransaction().commit();

            return getAccountByID(id);


        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

//    public void updateAccount(short id, String newUsername) {
//
//        Session session = null;
//
//        try {
//
//            // get session
//            session = hibernateUtils.openSession();
//            session.beginTransaction();
//
//            // get account
//            Account account = (Account) session.load(Account.class, id);
//
//            // update
//            account.setUsername(newUsername);
//
//            session.getTransaction().commit();
//
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//    }

    public void updateAccount(Account account) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // update
            session.update(account);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deleteAccount(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            session.beginTransaction();

            // get account
            Account account = (Account) session.load(Account.class, id);

            // delete
            if (account != null) {
                session.delete(account);
            }

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean isAccountExistsByID(short id) {

        // get account
        Account account = getAccountByID(id);

        // return result
        if (account == null) {
            return false;
        }

        return true;
    }

//    public boolean isAccountExistsByName(String name) {
//        Account account = getAccountByName(name);
//
//        if (account == null) {
//            return false;
//        }
//        return true;
//    }
}
