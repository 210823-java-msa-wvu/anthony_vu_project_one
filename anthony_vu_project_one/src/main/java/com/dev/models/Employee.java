package com.dev.models;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity(name = "employees")
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String eid;

    private String firstname;

    private String lastname;

    @Column(name = "totalbenefit")
    private Integer totBenefits;

    private Integer adminlevel;

    private Integer depart;

    public Employee() {
    }

    public Employee(String eid, String firstname, String lastname, Integer totBenefits, Integer adminlevel, Integer depart) {
        this.eid = eid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.totBenefits = totBenefits;
        this.adminlevel = adminlevel;
        this.depart = depart;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getTotBenefits() {
        return totBenefits;
    }

    public void setTotBenefits(Integer totBenefits) {
        this.totBenefits = totBenefits;
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

    @Override
    public String toString() {
        return "Employee{" +
                "eid='" + eid + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totBenefits=" + totBenefits +
                ", adminlevel=" + adminlevel +
                ", depart=" + depart +
                '}';
    }
}
