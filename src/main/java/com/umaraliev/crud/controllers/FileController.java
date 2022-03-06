package com.umaraliev.crud.controllers;

import com.umaraliev.crud.model.File;
import com.umaraliev.crud.model.User;
import com.umaraliev.crud.service.FileService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/file")
public class FileController extends HttpServlet {

    private FileService fileService;

    @Override
    public void init() throws ServletException {
        fileService = new FileService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        File file = new File();

        file.setName(request.getParameter("name"));

        fileService.save(file);

        PrintWriter out = response.getWriter();
        out.print("Save file");
        out.flush();
        response.sendRedirect("/file");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<File> fileList = fileService.getAll();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(fileList);
        out.flush();
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer id = Integer.valueOf(request.getParameter("id"));

        fileService.delete(id);

        response.sendRedirect("/file");

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        File file = new File();
        file.setId(Integer.valueOf(request.getParameter("id")));
        file.setName(request.getParameter("name"));
        fileService.update(file);

    }
}
