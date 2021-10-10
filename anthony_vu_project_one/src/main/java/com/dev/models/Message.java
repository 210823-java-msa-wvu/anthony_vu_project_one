package com.dev.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    private Integer id;
    private String eid;
    private String message;

    public Message() {
    }

    public Message(Integer id, String eid, String message) {
        this.id = id;
        this.eid = eid;
        this.message = message;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", eid='" + eid + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
