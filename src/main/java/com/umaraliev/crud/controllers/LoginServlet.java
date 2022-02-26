package com.umaraliev.crud.controllers;

import com.umaraliev.crud.repository.impl.UserRepositoryImpl;
import com.umaraliev.crud.service.AuthenticationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AuthenticationService authenticationService = new AuthenticationService(new UserRepositoryImpl());
        if (authenticationService.authenticate(username, password)) {
            HttpSession userSession = request.getSession();
            userSession.setAttribute("username", username);
            userSession.setAttribute("password", password);
        }
        else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}