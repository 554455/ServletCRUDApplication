package com.umaraliev.crud.repository.impl;

import com.umaraliev.crud.model.File;
import com.umaraliev.crud.repository.FileRepository;
import com.umaraliev.crud.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class FileRepositoryImpl implements FileRepository {

    private Transaction transaction;

    @Override
    public File getById(Integer integer) {

        File file = new File();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            file = session.get(File.class, integer);

            transaction.commit();

        }catch (Throwable e){
            System.out.println("IN get by id exception: " + e.getMessage());
        }

        return file;

    }

    @Override
    public List<File> getAll() {

        List<File> fileList = new ArrayList<>();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            fileList = session.createQuery("from File").list();

            transaction.commit();

        }catch (Throwable e){
            System.out.println("IN list file exception: " + e.getMessage());
        }

        return fileList;

    }

    @Override
    public File save(File file) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.save(file);

            transaction.commit();

        }catch (Throwable e){
            System.out.println("IN save exception: " + e.getMessage());
        }

        return file;

    }

    @Override
    public File update(File file) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.update(file);

            transaction.commit();

        }catch (Throwable e){
            System.out.println("IN update exception: " + e.getMessage());
        }
        return file;
    }

    @Override
    public boolean delete(Integer integer) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            File file = session.load(File.class, integer);

            session.delete(file);

            transaction.commit();

        }catch (Throwable e){
            System.out.println("IN delete exception: " + e.getMessage());
            return false;
        }

        return true;

    }
}
