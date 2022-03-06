package com.umaraliev.crud.repository.impl;

import com.umaraliev.crud.model.Event;
import com.umaraliev.crud.repository.EventRepository;
import com.umaraliev.crud.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author Umaraliev Bek
 */
public class EventRepositoryImpl implements EventRepository {
    
    private Transaction transaction;

    @Override
    public Event getById(Integer id) {
        
        Event event = null;
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            
            transaction = session.beginTransaction();
            
            event = session.get(Event.class, id);
            
            transaction.commit();
            
        }catch (Throwable e) {
            System.out.println("IN get by id exception: " + e.getMessage());
        }
        return event;
    }

    @Override
    public List<Event> getAll() {
        
        List<Event> listEvent = new ArrayList<>();
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
        
            transaction = session.beginTransaction();
            
            listEvent = session.createQuery("FROM Event", Event.class).getResultList();
            
            transaction.commit();
            
        }catch (Throwable e) {
            System.out.println("IN list event exception: " + e.getMessage());
        }
        return listEvent;
    }

    @Override
    public Event save(Event event) {
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            
            transaction = session.beginTransaction();
            
            session.save(event);
            
            transaction.commit();
            
        }catch (Throwable e) {
            System.out.println("IN save exception: " + e.getMessage());
        }
        return event;
    }

    @Override
    public Event update(Event event) {
        
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            
            transaction = session.beginTransaction();
            
            session.update(event);
            
            transaction.commit();
            
        }catch (Throwable e) {
            System.out.println("IN update exception: " + e.getMessage());
        }
        return event;
    }

    @Override
    public boolean delete(Integer id) {
        
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            
            transaction = session.beginTransaction();
            
            session.delete(id);
            
            transaction.commit();
            
        }catch (Throwable e) {
            System.out.println("IN delete exception: " + e.getMessage());
        }
        return true;
    }    
}
