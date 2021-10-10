package com.dev.models;

public class Admins {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer adminLevel;

    public Admins() {
    }

    public Admins(Integer id, String firstName, String lastName, Integer adminLevel) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adminLevel = adminLevel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAdminLevel() {
        return adminLevel;
    }

    public void setAdminLevel(Integer adminLevel) {
        this.adminLevel = adminLevel;
    }

    @Override
    public String toString() {
        return "Admins{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", adminLevel=" + adminLevel +
                '}';
    }
}
