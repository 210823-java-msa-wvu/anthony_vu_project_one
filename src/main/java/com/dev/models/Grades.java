package com.dev.models;

import javax.persistence.*;

@Entity
@Table(name = "grades")
public class Grades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String letter;

    @Column(name = "describegrade")
    private String gradeDescribe;

    public Grades() {
    }

    public Grades(Integer id, String letter, String gradeDescribe) {
        this.id = id;
        this.letter = letter;
        this.gradeDescribe = gradeDescribe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getGradeDescribe() {
        return gradeDescribe;
    }

    public void setGradeDescribe(String gradeDescribe) {
        this.gradeDescribe = gradeDescribe;
    }

    @Override
    public String toString() {
        return "Grades{" +
                "id=" + id +
                ", letter='" + letter + '\'' +
                ", gradeDescribe='" + gradeDescribe + '\'' +
                '}';
    }
}
