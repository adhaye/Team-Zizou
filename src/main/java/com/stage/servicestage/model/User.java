package com.stage.servicestage.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


@Entity
@Table(name="user")
//@JsonFilter("monFiltreDynamique")
public class User {

    @Id
    @GeneratedValue
    @Column(name="id_user")
    public int IDUser;
    @Column(name="email")
    private String Email;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="type")
    private Integer type;

    /*private int StudentNumber;
    private String CourseUser;
    private String TypeOfContactUser;*/

    public User() {
    }

    public int getIDUSER() {
        return IDUser;
    }

    public void setIDUser(int IDUSER) {
        this.IDUser = IDUser;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    /*public int getStudentNumber() {
        return StudentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        StudentNumber = studentNumber;
    }

    public String getCourseUser() {
        return CourseUser;
    }

    public void setCourseUser(String courseUser) {
        CourseUser = courseUser;
    }

    public String getTypeOfContactUser() {
        return TypeOfContactUser;
    }

    public void setTypeOfContactUser(String typeOfContactUser) {
        TypeOfContactUser = typeOfContactUser;
    }
*/



}