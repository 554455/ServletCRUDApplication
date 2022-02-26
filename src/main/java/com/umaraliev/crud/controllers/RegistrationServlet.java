package com.umaraliev.crud.controllers;

import com.umaraliev.crud.model.User;
import com.umaraliev.crud.repository.impl.UserRepositoryImpl;
import com.umaraliev.crud.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reg")
public class RegistrationServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() {
        userService = new UserService(new UserRepositoryImpl());
    }

    UserController userController = new UserController();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//            User user = new User();
//            user.setName(username);
//            user.setPassword(Integer.valueOf(password));
//            user.setLogin(user.getName() + "@mail.ru");
//            userService.save(user);
//
            userController.doPost(request, response);
    }


}

