package com.umaraliev.crud.controllers;

import com.umaraliev.crud.model.Event;
import com.umaraliev.crud.model.File;
import com.umaraliev.crud.model.User;
import com.umaraliev.crud.service.EventService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Umaraliev Bek
 */

@WebServlet("/event")
public class EventController extends HttpServlet{
    
    private EventService eventService;

    @Override
    public void init() throws ServletException {
        eventService = new EventService();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        List<Event> eventList = eventService.getAll();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(eventList);
        out.flush();
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = new User();

        user.setName(request.getParameter("user-name"));

        File file = new File();

        file.setName(request.getParameter("file-name"));

        Event event = new Event();

        event.setUser(user);
        event.setFile(file);

        eventService.save(event);

        PrintWriter out = response.getWriter();
        out.print("Save event");
        out.flush();
        response.sendRedirect("/event");

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.valueOf(request.getParameter("id"));

        eventService.delete(id);

        response.sendRedirect("/event");
    }

}
