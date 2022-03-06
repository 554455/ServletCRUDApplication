package com.umaraliev.crud.service;

import com.umaraliev.crud.model.Event;
import com.umaraliev.crud.repository.impl.EventRepositoryImpl;
import java.util.List;

/**
 *
 * @author Umaraliev Bek
 */
public class EventService {
    
    private EventRepositoryImpl eventRepositoryImpl;
    
    public Event getById(Integer id){
        return eventRepositoryImpl.getById(id);
    }
    
    public List<Event> getAll(){
        return eventRepositoryImpl.getAll();
    }
    
    public Event save(Event event){
        return eventRepositoryImpl.save(event);
    }
    
    public Event update(Event event){
        return eventRepositoryImpl.update(event);
    }
    
    public boolean delete(Integer id){
        return eventRepositoryImpl.delete(id);
    }
}
