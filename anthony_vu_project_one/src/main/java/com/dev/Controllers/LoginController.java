package com.dev.Controllers;

import com.dev.models.Application;
import com.dev.models.Employee;
import com.dev.repositories.ApplicationRepo;
import com.dev.repositories.MessageJDBC;
import com.dev.repositories.MessengerRepo;
import com.dev.repositories.hibernate.MessengerHibernate;
import com.dev.repositories.hibernate.UserHibernate;
import com.dev.services.UserServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController implements FrontController{

    private final Logger log = LogManager.getLogger(LoginController.class);
    private UserServices userServices = new UserServices();
    private ObjectMapper om = new ObjectMapper();
    private UserHibernate uh = new UserHibernate();
    private MessageJDBC mj = new MessageJDBC();
    private ApplicationRepo ar = new ApplicationRepo();
    private MessengerRepo messengerRepo = new MessengerHibernate();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        log.info("Application Starts");

        String lastname = request.getParameter("lastname");
        String eid = request.getParameter("eid");
        System.out.println("Last Name: " + lastname + " EID: " + eid);

        log.trace("Creation of Cookies to be sent.");
        Cookie cookie = new Cookie("userinfo", om.writeValueAsString(uh.getByName(eid)));
        Cookie messageCookie = new Cookie("message",om.writeValueAsString(mj.getAllByEid(eid)));
        Cookie approvedCookie = new Cookie("approval", om.writeValueAsString(ar.getByApproval()));
        Cookie employeeCookie = new Cookie("employees", om.writeValueAsString(uh.getAll()));
        Cookie adminmessenger = new Cookie("adminmessenger", om.writeValueAsString(mj.getAllAdminMessage()));
        Employee employ = null;
        employ = om.readValue(cookie.getValue(), Employee.class);
        Cookie department = new Cookie("department", om.writeValueAsString(ar.getByDepart(employ.getDepart())));


        Employee e = (userServices.login(lastname, eid));

        if (e != null){
            if (e.getAdminlevel() == 0){
                response.addCookie(cookie);
                response.addCookie(messageCookie);
                response.setStatus(200);
                System.out.println(om.writeValueAsString(uh.getByName(eid)));
                log.info("Employee has been Logged In.");
                response.sendRedirect("static/employeepage.html");
                System.out.println("Working");
            } else if (e.getAdminlevel() == 1 || e.getAdminlevel() == 2){
                response.addCookie((department));
                response.addCookie(cookie);
                response.addCookie(adminmessenger);
                response.setStatus(200);
                System.out.println(om.writeValueAsString(uh.getByName(eid)));
                log.info("Director/Manager has been Logged In.");
                response.sendRedirect("static/adminpage.html");
                System.out.println("Working");
            } else {
                response.addCookie(cookie);
                response.addCookie(approvedCookie);
                response.addCookie(employeeCookie);
                response.addCookie(adminmessenger);
                response.setStatus(200);
                System.out.println(om.writeValueAsString(uh.getByName(eid)));
                log.info("BenCo has been Logged In.");
                response.sendRedirect("static/benco.html");
                System.out.println("Working");
            }

        } else {
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            response.setStatus(403);
            response.getWriter().write("You have the wrong info.");
        }
    }
}
