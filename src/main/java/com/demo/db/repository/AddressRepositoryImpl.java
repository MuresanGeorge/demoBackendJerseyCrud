package com.demo.db.repository;

import com.demo.db.HibernateUtil;
import com.demo.model.Address;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AddressRepositoryImpl implements AddressRepository {

    @Override
    public void createAddress(Address address) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(address);
            transaction.commit();
        } catch (HibernateException e) {
            HibernateUtil.rollbackTransaction(transaction);
        } finally {
            session.close();
        }
    }

    @Override
    public Address getAddressById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Address user = new Address();
        try {
            transaction = session.beginTransaction();
            user = session.createNativeQuery("select * from address where adress_id =" + id + ";", Address.class).getSingleResult();
        } catch (HibernateException e) {
            HibernateUtil.rollbackTransaction(transaction);
        } finally {
            session.close();
        }
        return user;
    }

    @Override
    public List<Address> getAllAddresses() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Address> userList = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            userList = session.createNativeQuery("select * from address", Address.class).getResultList();
        } catch (HibernateException e) {
            HibernateUtil.rollbackTransaction(transaction);
        } finally {
            session.close();
        }
        return userList;
    }
}
