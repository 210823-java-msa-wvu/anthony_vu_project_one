package com.dev.Controllers;

import com.dev.models.Application;
import com.dev.models.Decision;
import com.dev.models.Employee;
import com.dev.models.Messenger;
import com.dev.repositories.ApplicationRepo;
import com.dev.repositories.MessageJDBC;
import com.dev.repositories.hibernate.ApplyHibernate;
import com.dev.repositories.hibernate.UserHibernate;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class AdminController implements FrontController{

    private ObjectMapper om = new ObjectMapper();
    private ApplyHibernate ah = new ApplyHibernate();
    private ApplicationRepo ar = new ApplicationRepo();
    private UserHibernate uh = new UserHibernate();
    private MessageJDBC mj = new MessageJDBC();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String path = (String) request.getAttribute("path");
        System.out.println("Path attribute: " + path);
        Double re = 0.0;

        if (path == null || path.equals("")) { // http://localhost:8080/LibraryServlet/books

            switch (request.getMethod()) {

                case "GET": {

                    break;
                }

                case "POST": {

                    Decision d = om.readValue(request.getReader(), Decision.class);
                    Integer id = d.getId();
                    String eid = d.getEid();
                    String choice = d.getChoice();
                    String reason = d.getReason();
                    String lastname = d.getLastname();
                    String message = d.getMessage();
                    String last = d.getLast();
                    Integer adminlevel = d.getAdminlevel();
                    Integer depart = d.getDepart();
                    System.out.println("Employee ID: " + last + "  Admin Decision: " + choice + "  Admin Level: " + adminlevel + "  Department: Department " + depart);


                    if (last.equals("")){
                        if(choice.equals("true")) {
                            switch (adminlevel) {
                                case 1: {
                                    ar.updateAppAdmin1(id, choice, depart);
                                    response.setStatus(HttpServletResponse.SC_NO_CONTENT);
                                    break;
                                }
                                case 2: {
                                    ar.updateAppAdmin2(id, choice, depart);
                                    response.setStatus(HttpServletResponse.SC_NO_CONTENT);
                                    break;
                                }
                                case 3: {
                                    ar.updateAppAdmin3(id, choice);
                                    response.setStatus(HttpServletResponse.SC_NO_CONTENT);
                                    break;
                                }
                            }
                        } else if (choice.equals("false")) {
                            switch (adminlevel) {
                                case 1: {
                                    ar.updateAppAdmin1(id, choice, depart);
                                    ar.appMessage(eid, reason);
                                    response.setStatus(HttpServletResponse.SC_NO_CONTENT);
                                    break;
                                }
                                case 2: {
                                    ar.updateAppAdmin2(id, choice, depart);
                                    ar.appMessage(eid, reason);
                                    response.setStatus(HttpServletResponse.SC_NO_CONTENT);
                                    break;
                                }
                                case 3: {
                                    //ar.updateAppAdmin3(eid, choice, depart);
                                    ar.appMessage(eid, reason);
                                    response.setStatus(HttpServletResponse.SC_NO_CONTENT);
                                    break;
                                }
                            }
                        }
                    } else {
                        mj.addAdminMessage(lastname,message);
                        response.setStatus(200);
                    }
                    break;
                }
            }


        } else {
            switch (request.getMethod()) {
                // /books/1
                case "GET": {

                    break;
                }

                case "PUT": {

                    break;
                }
                case "DELETE": {

                    break;
                }

                default: {
                    response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
                    break;
                }
            }
        }
    }
}
