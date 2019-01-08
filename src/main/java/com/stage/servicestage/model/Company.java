package com.internsheep.blog.Model;

public class Company {
    private int IDCompany;
    private String NameCompany;



    public int getIDCompany() {
        return IDCompany;
    }

    public void setIDCompany(int IDCompany) {
        this.IDCompany = IDCompany;
    }

    public String getNameCompany() {
        return NameCompany;
    }

    public void setNameCompany(String nameCompany) {
        NameCompany = nameCompany;
    }

    public Company(int IDCompany, String nameCompany) {
        this.IDCompany = IDCompany;
        NameCompany = nameCompany;
    }
}
