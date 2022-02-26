package com.umaraliev.crud.controllers;

import com.umaraliev.crud.repository.impl.UserRepositoryImpl;
import com.umaraliev.crud.service.AuthenticationService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter", servletNames = {"FileController", "UserController"})
public class AuthenticationFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String username = (String) httpServletRequest.getSession().getAttribute("username");
        String password = (String) httpServletRequest.getSession().getAttribute("password");

        AuthenticationService authenticationService = new AuthenticationService(new UserRepositoryImpl());
        if (authenticationService.authenticate(username, password)) {
            chain.doFilter(request, response);
        }
        else {
            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}