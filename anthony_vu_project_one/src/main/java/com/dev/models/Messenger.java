package com.dev.models;

import javax.persistence.*;

@Entity(name = "messager")
@Table(name = "messager")
public class Messenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String lastname;
    private String message;

    public Messenger() {
    }

    public Messenger(String lastname, String message) {
        this.lastname = lastname;
        this.message = message;
    }

    public Messenger(Integer id, String lastname, String message) {
        this.id = id;
        this.lastname = lastname;
        this.message = message;
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

    @Override
    public String toString() {
        return "Messenger{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
