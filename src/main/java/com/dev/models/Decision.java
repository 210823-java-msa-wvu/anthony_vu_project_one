package com.dev.models;

import javax.persistence.criteria.CriteriaBuilder;

public class Decision {
    private Integer id;
    private String eid;
    private String choice;
    private String reason;
    private String last;
    private String lastname;
    private String message;
    private Integer adminlevel;
    private Integer depart;

    public Decision() {
    }

    public Decision(String lastname, String message) {
        this.lastname = lastname;
        this.message = message;
    }

    public Decision(Integer id, String eid, String choice, String reason, Integer adminlevel, Integer depart) {
        this.id = id;
        this.eid = eid;
        this.choice = choice;
        this.reason = reason;
        this.adminlevel = adminlevel;
        this.depart = depart;
    }

    public Decision(Integer id, String eid, String choice, String reason, String last, String lastname, String message, Integer adminlevel, Integer depart) {
        this.id = id;
        this.eid = eid;
        this.choice = choice;
        this.reason = reason;
        this.last = last;
        this.lastname = lastname;
        this.message = message;
        this.adminlevel = adminlevel;
        this.depart = depart;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getAdminlevel() {
        return adminlevel;
    }

    public void setAdminlevel(Integer adminlevel) {
        this.adminlevel = adminlevel;
    }

    public Integer getDepart() {
        return depart;
    }

    public void setDepart(Integer depart) {
        this.depart = depart;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return "Decision{" +
                "id=" + id +
                ", eid='" + eid + '\'' +
                ", choice='" + choice + '\'' +
                ", reason='" + reason + '\'' +
                ", last='" + last + '\'' +
                ", lastname='" + lastname + '\'' +
                ", message='" + message + '\'' +
                ", adminlevel=" + adminlevel +
                ", depart=" + depart +
                '}';
    }
}
