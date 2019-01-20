package com.stage.servicestage.model;


import javax.persistence.*;


@Entity
@Table(name="user")
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
    @Column(name="confirmPassword")
    private String confirmPassword;
    @Column(name="type")
    private Integer type;

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

    public String getConfirmPassword() {return confirmPassword;    }

    public void setConfirmPassword(String confirmPassword) {this.confirmPassword = confirmPassword;    }


}