package com.dev.Controllers;

import com.dev.models.Benco;
import com.dev.models.Decision;
import com.dev.models.Employee;
import com.dev.repositories.ApplicationRepo;
import com.dev.repositories.EmployeesRepo;
import com.dev.repositories.MessageJDBC;
import com.dev.repositories.hibernate.ApplyHibernate;
import com.dev.repositories.hibernate.UserHibernate;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BencoController implements FrontController{

    private ObjectMapper om = new ObjectMapper();
    private ApplyHibernate ah = new ApplyHibernate();
    private ApplicationRepo ar = new ApplicationRepo();
    private UserHibernate uh = new UserHibernate();
    private MessageJDBC mj = new MessageJDBC();
    private EmployeesRepo er = new EmployeesRepo();

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
                    System.out.println("Benco Post");



                    Benco b = om.readValue(request.getReader(), Benco.class);
                    Integer id = b.getId();
                    String eid = b.getEid();
                    String choice = b.getChoice();
                    Integer reim = b.getReim();
                    String reason = b.getReason();
                    String present = b.getPresent();
                    String approvepresent = b.getApprovepresent();
                    Integer adminlevel = b.getAdminlevel();
                    Integer depart = b.getDepart();
                    String lastname = b.getLastname();
                    String message = b.getMessage();
                    Integer zero = 0;

                    Employee employee = er.getById(eid);

                    Integer total = employee.getTotBenefits();
                    System.out.println(total);



                    if (message == null){
                        if (approvepresent.equals("Yes")){
                            ar.updateAppAdmin3(id, choice, depart);
                            ar.approvePresent(id, approvepresent);
                            if(reim != null){
                                ar.updateReimbursement(id, reim);
                                ar.adjustRe(id, reim);
                                ar.updateBenefits(eid, reim);
                                System.out.println("Before Zero");
                                if(total < 0) {
                                    System.out.println("No Zero");
                                    ar.updateZero(eid, zero);
                                    String text = "You have Exceeded your Benefits.";
                                    ar.setStatus(id, text);
                                }
                            }
                            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
                        } else if (approvepresent.equals("No")){
                            ar.updateAppAdmin3(id, choice, depart);
                            ar.appMessage(eid, reason);
                            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
                        }
                    } else if (message != null){
                        mj.addAdminMessage(lastname, message);
                    }


                    System.out.println("Employee ID: " + id + "  Admin Decision: " + choice + "  Admin Level: " + adminlevel + "  Department: Department " + depart);

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
