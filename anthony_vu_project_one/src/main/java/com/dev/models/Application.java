package com.dev.models;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "application")
@Table(name = "application")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String eid;

    @Column(name = "todaydate")
    private String todayDate;

    private String location;
    private String description;
    private Integer cost;
    private String grade;

    @Column(name = "typeevent")
    private String event;

    @Column(name = "justification")
    private String justify;

    private Double reimbursement;
    private String status;

    private Integer depart;
    private String present;
    private String approvepresent;

    private Boolean admin1;
    private Boolean admin2;
    private Boolean admin3;

    public Application() {
    }

    public Application(String eid, String todayDate, String location, String description, Integer cost, String grade, String event, String justify, Double reimbursement, String status, Integer depart, String present, String approvepresent, Boolean admin1, Boolean admin2, Boolean admin3) {
        this.eid = eid;
        this.todayDate = todayDate;
        this.location = location;
        this.description = description;
        this.cost = cost;
        this.grade = grade;
        this.event = event;
        this.justify = justify;
        this.reimbursement = reimbursement;
        this.status = status;
        this.depart = depart;
        this.present = present;
        this.approvepresent = approvepresent;
        this.admin1 = admin1;
        this.admin2 = admin2;
        this.admin3 = admin3;
    }

    public Application(Integer id, String eid, String todayDate, String location, String description, Integer cost, String grade, String event, String justify, Double reimbursement, String status, Integer depart, String present, String approvepresent, Boolean admin1, Boolean admin2, Boolean admin3) {
        this.id = id;
        this.eid = eid;
        this.todayDate = todayDate;
        this.location = location;
        this.description = description;
        this.cost = cost;
        this.grade = grade;
        this.event = event;
        this.justify = justify;
        this.reimbursement = reimbursement;
        this.status = status;
        this.depart = depart;
        this.present = present;
        this.approvepresent = approvepresent;
        this.admin1 = admin1;
        this.admin2 = admin2;
        this.admin3 = admin3;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getTodayDate() {
        return todayDate;
    }

    public void setTodayDate(String todayDate) {
        this.todayDate = todayDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getJustify() {
        return justify;
    }

    public void setJustify(String justify) {
        this.justify = justify;
    }

    public Double getReimbursement() {
        return reimbursement;
    }

    public void setReimbursement(Double reimbursement) {
        this.reimbursement = reimbursement;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDepart() {
        return depart;
    }

    public void setDepart(Integer depart) {
        this.depart = depart;
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
    }

    public String getApprovepresent() {
        return approvepresent;
    }

    public void setApprovepresent(String appovepresent) {
        this.approvepresent = appovepresent;
    }

    public Boolean getAdmin1() {
        return admin1;
    }

    public void setAdmin1(Boolean admin1) {
        this.admin1 = admin1;
    }

    public Boolean getAdmin2() {
        return admin2;
    }

    public void setAdmin2(Boolean admin2) {
        this.admin2 = admin2;
    }

    public Boolean getAdmin3() {
        return admin3;
    }

    public void setAdmin3(Boolean admin3) {
        this.admin3 = admin3;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", eid='" + eid + '\'' +
                ", todayDate='" + todayDate + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", grade='" + grade + '\'' +
                ", event='" + event + '\'' +
                ", justify='" + justify + '\'' +
                ", reimbursement=" + reimbursement +
                ", status='" + status + '\'' +
                ", depart=" + depart +
                ", present='" + present + '\'' +
                ", approvepresent='" + approvepresent + '\'' +
                ", admin1=" + admin1 +
                ", admin2=" + admin2 +
                ", admin3=" + admin3 +
                '}';
    }
}
