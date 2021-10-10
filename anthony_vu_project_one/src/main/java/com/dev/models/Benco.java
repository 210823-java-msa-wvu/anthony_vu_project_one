package com.dev.models;

public class Benco {

    private Integer id;
    private String eid;
    private String choice;
    private Integer reim;
    private String reason;
    private String present;
    private String approvepresent;
    private Integer adminlevel;
    private Integer depart;
    private Integer totalbenefit;
    private String lastname;
    private String message;

    public Benco() {
    }

    public Benco(String lastname, String message) {
        this.lastname = lastname;
        this.message = message;
    }

    public Benco(String eid, String choice, Integer reim, String reason, String present, String approvepresent, Integer adminlevel, Integer depart, Integer totalbenefit) {
        this.eid = eid;
        this.choice = choice;
        this.reim = reim;
        this.reason = reason;
        this.present = present;
        this.approvepresent = approvepresent;
        this.adminlevel = adminlevel;
        this.depart = depart;
        this.totalbenefit = totalbenefit;
    }

    public Benco(Integer id, String eid, String choice, Integer reim, String reason, String present, String approvepresent, Integer adminlevel, Integer depart, Integer totalbenefit) {
        this.id = id;
        this.eid = eid;
        this.choice = choice;
        this.reim = reim;
        this.reason = reason;
        this.present = present;
        this.approvepresent = approvepresent;
        this.adminlevel = adminlevel;
        this.depart = depart;
        this.totalbenefit = totalbenefit;
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

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public Integer getReim() {
        return reim;
    }

    public void setReim(Integer reim) { this.reim = reim; }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
    }

    public String getApprovepresent() { return approvepresent; }

    public void setApprovepresent(String approvepresent) {this.approvepresent = approvepresent;}

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

    public Integer getTotalbenefit() {
        return totalbenefit;
    }

    public void setTotalbenefit(Integer totalbenefit) {
        this.totalbenefit = totalbenefit;
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

    @Override
    public String toString() {
        return "Benco{" +
                "id=" + id +
                ", eid='" + eid + '\'' +
                ", choice='" + choice + '\'' +
                ", reim=" + reim +
                ", reason='" + reason + '\'' +
                ", present='" + present + '\'' +
                ", approvepresent='" + approvepresent + '\'' +
                ", adminlevel=" + adminlevel +
                ", depart=" + depart +
                ", totalbenefit=" + totalbenefit +
                ", lastname='" + lastname + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
