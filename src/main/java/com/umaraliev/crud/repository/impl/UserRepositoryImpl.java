package com.umaraliev.crud.repository.impl;

import com.umaraliev.crud.model.User;
import com.umaraliev.crud.repository.UserRepository;
import com.umaraliev.crud.utils.HibernateUtil;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;


import javax.persistence.Query;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private Transaction transaction;

    public User getById(Integer integer) {

        User user = new User();

        try (Session session = HibernateUtil.getSessionFactory().openSession()){

            transaction = session.beginTransaction();

            user = session.get(User.class, integer);

            transaction.commit();

        }catch (Throwable e){
            System.out.println("IN get by id exception: " + e.getMessage());
        }

        return user;
    }

    public List<User> getAll() {

        List<User> userList = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            userList = session.createQuery("FROM User", User.class).getResultList();

        }catch (Throwable e){
            System.out.println("IN get all exception: " + e.getMessage());
        }

        return userList;
    }

    @Override
    public User save(User user) {


        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.saveOrUpdate(user);

            transaction.commit();
        }catch (Throwable e){
            System.out.println("IN save exception: " + e.getMessage());
        }

        return user;
    }

    public User update(User user) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.update(user);

        }catch (Throwable e){
            System.out.println("IN update exception: " + e.getMessage());
        }

        return user;
    }

    public boolean delete(Integer id) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            User user = session.load(User.class, id);

            session.delete(user);

            transaction.commit();
        }catch (Throwable e){
            System.out.println("IN delete exception: " + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public User getByUsername(String name) {

        User user = new User();

        try (Session session = HibernateUtil.getSessionFactory().openSession()){

            transaction = session.beginTransaction();

            Query query = session.createQuery("from User where name = :name");
            query.setParameter("name", name);

            List<User> userList = query.getResultList();

            user = userList.get(0);

            transaction.commit();

        }catch (Throwable e){
            System.out.println("IN get by id exception: " + e.getMessage());
        }

        return user;
    }
}
