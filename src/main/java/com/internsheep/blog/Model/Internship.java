package com.internsheep.blog.Model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@JsonFilter("monFiltreDynamique")
public class Internship {

    @Id
    @GeneratedValue
    private int id;
    private String companyName;
    private int salary;
    private String tel;

    public Internship(){}


    public Internship(int id, String companyName, int salary, String tel) {
        this.id = id;
        this.companyName = companyName;
        this.salary = salary;
        this.tel = tel;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getsalary() {
        return salary;
    }

    public void setsalary(int salary) {
        salary = salary;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Internship{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", salary=" + salary +
                ", tel=" + tel +
                '}';
    }



}
