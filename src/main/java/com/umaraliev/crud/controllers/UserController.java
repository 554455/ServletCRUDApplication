package com.umaraliev.crud.controllers;


import com.umaraliev.crud.model.File;
import com.umaraliev.crud.model.User;
import com.umaraliev.crud.repository.impl.UserRepositoryImpl;
import com.umaraliev.crud.service.UserService;
import org.jetbrains.annotations.NotNull;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/user")
public class UserController extends HttpServlet {

    private UserService userService;

    @Override
    public void init() {
        userService = new UserService(new UserRepositoryImpl());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = new User();

        user.setName(request.getParameter("name"));
        user.setLogin(request.getParameter("login"));
        user.setPassword(Integer.valueOf(request.getParameter("password")));

        userService.save(user);

        PrintWriter out = response.getWriter();
        out.print("name: " + user.getName()
                + " login: " + user.getLogin()
                + " password:" + user.getPassword());
        out.flush();
        response.sendRedirect("/user");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<User> userList = userService.getAll();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(userList);
        out.flush();

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User file = new User();
        file.setId(Integer.valueOf(request.getParameter("id")));
        file.setName(request.getParameter("name"));
        userService.update(file);

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.valueOf(request.getParameter("id"));

        userService.delete(id);

        response.sendRedirect("/user");
    }
}
