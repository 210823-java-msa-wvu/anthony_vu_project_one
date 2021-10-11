package com.dev.Controllers;

import com.dev.models.Application;
import com.dev.models.Decision;
import com.dev.models.Employee;
import com.dev.models.Message;
import com.dev.repositories.ApplicationRepo;
import com.dev.repositories.MessageJDBC;
import com.dev.repositories.hibernate.ApplyHibernate;
import com.dev.repositories.hibernate.UserHibernate;
import com.dev.services.UserServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeController implements FrontController{

    private Logger log = LogManager.getLogger(LoginController.class);
    private UserServices userServices = new UserServices();
    private ObjectMapper om = new ObjectMapper();
    private UserHibernate uh = new UserHibernate();
    private ApplyHibernate ah = new ApplyHibernate();
    private ApplicationRepo ar = new ApplicationRepo();
    private MessageJDBC mj = new MessageJDBC();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String eid = request.getParameter("eid");
        System.out.println(eid);

        String path = (String) request.getAttribute("path");
        System.out.println("Path attribute: " + path);
        System.out.println(path);
        Double re = 0.0;

        if (path == null || path.equals("")) { // http://localhost:8080/LibraryServlet/books

            switch (request.getMethod()) {

                case "GET": {
//                    Cookie[] cookies = request.getCookies();
//                    Message e = null;
//
//                    for (Cookie cookie : cookies){
//                        if(cookie.getName().equals("message")){
//                            e = om.readValue(cookie.getValue(), Message.class);
//                        }
//                    }
//                    System.out.println("Print");
//
//                    String id = e.getEid();
////                    String message = e.getMessage();
//
//                    Cookie newmessage = new Cookie("newmessage", om.writeValueAsString(mj.getAllByEid(id)));
//                    response.getWriter().write(om.writeValueAsString(mj.getAllByEid(id)));
//                    response.addCookie(newmessage);
//                    response.setStatus(200);

                    break;
                }

                case "POST": {
                    Cookie[] cookies = request.getCookies();
                    Employee e = null;

                    for (Cookie cookie : cookies){
                        if(cookie.getName().equals("userinfo")){
                            e = om.readValue(cookie.getValue(), Employee.class);
                        }
                    }


                    Application a = new Application();
                    a.setEid(request.getParameter("eid"));
                    a.setTodayDate(request.getParameter("date"));
                    a.setLocation(request.getParameter("states"));
                    a.setDescription(request.getParameter("eventdescript"));
                    a.setCost(Integer.parseInt(request.getParameter("cost")));
                    a.setGrade(request.getParameter("grade"));
                    a.setPresent(request.getParameter("present"));
                    a.setEvent(request.getParameter("source"));
                    a.setJustify(request.getParameter("reason"));
                    a.setDepart(e.getDepart());
                    System.out.println(a);

                    switch (request.getParameter("source")){
                        case "University Classes": {
                            Double c = Double.parseDouble(request.getParameter("cost"));
                            re = c - (c * .80);
                            a.setReimbursement(re);
                            break;
                        }
                        case "Seminar": {
                            Double c = Double.parseDouble(request.getParameter("cost"));
                            re = c - (c * .60);
                            a.setReimbursement(re);
                            break;
                        }
                        case "Certification Preparation Classes": {
                            Double c = Double.parseDouble(request.getParameter("cost"));
                            re = c - (c * .75);
                            a.setReimbursement(re);
                            break;
                        }
                        case "Certification": {
                            Double c = Double.parseDouble(request.getParameter("cost"));
                            re = c - (c * 1.0);
                            a.setReimbursement(re);
                            break;
                        }
                        case "Technical Training": {
                            Double c = Double.parseDouble(request.getParameter("cost"));
                            re = c - (c * .95);
                            a.setReimbursement(re);
                            break;
                        }
                        case "Other": {
                            Double c = Double.parseDouble(request.getParameter("cost"));
                            re = c - (c * .30);
                            a.setReimbursement(re);
                            break;
                        }
                        default:
                            System.out.println("Done");
                    }

                    System.out.println("Before SQL");
                    ar.add(a);
                    response.sendRedirect("static/employeepage.html");
                    break;
                }
            }


        } else {
            switch (request.getMethod()) {
                // /books/1
                case "GET": {
//                    Cookie[] cookies = request.getCookies();
//                    Message e = null;
//
//                    for (Cookie cookie : cookies){
//                        if(cookie.getName().equals("message")){
//                            e = om.readValue(cookie.getValue(), Message.class);
//                        }
//                    }
//                    System.out.println("Print");
//
//                    String id = e.getEid();
////                    String message = e.getMessage();
//
//                    Cookie newmessage = new Cookie("newmessage", om.writeValueAsString(mj.getAllByEid(id)));
//                    response.getWriter().write(om.writeValueAsString(mj.getAllByEid(id)));
//                    response.addCookie(newmessage);
//                    response.setStatus(200);

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
