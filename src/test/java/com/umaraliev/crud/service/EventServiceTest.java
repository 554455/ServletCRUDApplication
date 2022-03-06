package com.umaraliev.crud.service;

import com.umaraliev.crud.model.Event;
import com.umaraliev.crud.repository.EventRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class EventServiceTest {

    @Mock
    private EventService eventService;

    @InjectMocks
    private EventRepository eventRepository = mock(EventRepository.class);
    private Event oneEvent;
    private Event twoEvent;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getById() {
        List<Event> eventList = new ArrayList<>();
        eventList.add(oneEvent);
        eventList.add(twoEvent);

        when(eventService.getAll()).thenReturn(eventList);
        when(eventService.getById(1)).thenReturn(oneEvent);
    }

    @Test
    public void getAll() {

        List<Event> eventList = new ArrayList<>();

        eventList.add(oneEvent);
        eventList.add(twoEvent);

        when(eventService.getAll()).thenReturn(eventList);
        assertNotNull(eventList);
    }

    @Test
    public void delete() {
        eventService.delete(anyInt());

        verify(eventService).delete(anyInt());
    }
}