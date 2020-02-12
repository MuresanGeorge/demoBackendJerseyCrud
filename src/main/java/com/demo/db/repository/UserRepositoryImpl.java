package com.demo.db.repository;

import com.demo.db.HibernateUtil;
import com.demo.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public void createUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (HibernateException e) {
            HibernateUtil.rollbackTransaction(transaction);
        } finally {
            session.close();
        }
    }

    @Override
    public User getUserById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        User user = new User();
        try {
            transaction = session.beginTransaction();
            user = session.createNativeQuery("select * from user where user_id =" + id + ";", User.class).getSingleResult();
        } catch (HibernateException e) {
            HibernateUtil.rollbackTransaction(transaction);
        } finally {
            session.close();
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<User> userList = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            userList = session.createNativeQuery("select * from user", User.class).getResultList();
        } catch (HibernateException e) {
            HibernateUtil.rollbackTransaction(transaction);
        } finally {
            session.close();
        }
        return userList;
    }
}
