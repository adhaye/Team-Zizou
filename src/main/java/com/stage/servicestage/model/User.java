package com.internsheep.blog.Model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@JsonFilter("monFiltreDynamique")
public class User {

    private int IDUser;
    private String EmailAddress;
    private String Pseudo;
    private String password;
    private int StudentNumber;
    private String CourseUser;
    private String TypeOfContactUser;




}