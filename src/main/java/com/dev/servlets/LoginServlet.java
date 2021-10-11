package com.dev.servlets;

import com.dev.models.Employee;
import com.dev.services.UserServices;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    private ObjectMapper om = new ObjectMapper();
    private UserServices userServices = new UserServices();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//
//        String lastname = request.getParameter("lastname");
//        String eid = request.getParameter("eid");
//
//        boolean user = userServices.login(lastname,eid);
//
//        if (user) {
//            System.out.println("Yes");
//            response.sendRedirect("static/employeepage.html");
//
//        } else {
//            System.out.println("Your credentials do not match.\n");
//        }
//
    }
}
