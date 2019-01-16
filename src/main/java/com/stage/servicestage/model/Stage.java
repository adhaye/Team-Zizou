package com.stage.servicestage.model;

import javax.persistence.*;

@Entity
@Table(name="stage")
public class Stage {

    @Id
    @GeneratedValue
    @Column(name = "id_stage")
    private int idStage;
    @Column(name = "poste")
    private String poste;
    @Column(name = "entreprise")
    private String entreprise;
    @Column(name = "localisation")
    private String localisation;
    @Column(name = "date")
    private String date;
    @Column(name = "duree")
    private String duree;
    @Column(name = "commentaire")
    private String commentaire;
    @Column(name = "gratification")
    private Integer gratification;
    @Column(name = "parcours")
    private String parcours;
    @Column(name = "note")
    private Integer note;

    public Stage() {

    }

    public Stage(String poste, String entreprise, String localisation, String date, String duree, String commentaire, Integer gratification, String parcours, Integer note) {
        this.poste = poste;
        this.entreprise = entreprise;
        this.localisation = localisation;
        this.date = date;
        this.duree = duree;
        this.commentaire = commentaire;
        this.gratification = gratification;
        this.parcours = parcours;
        this.note = note;
    }

    public int getIdStage() {
        return idStage;
    }

    public void setIdStage(int idStage) {
        this.idStage = idStage;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Integer getGratification() {
        return gratification;
    }

    public void setGratification(Integer gratification) {
        this.gratification = gratification;
    }

    public String getParcours() {
        return parcours;
    }

    public void setParcours(String parcours) {
        this.parcours = parcours;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

}