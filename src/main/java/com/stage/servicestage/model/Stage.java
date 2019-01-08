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
    /*@Column(name = "date")
    private String date;
    @Column(name = "duree")
    private String duree;
    @Column(name = "commentaire")
    private String commentaire;
    @Column(name = "gratification")
    private String gratification;
    @Column(name = "parcours")
    private String parcours;
    @Column(name = "note")
    private String note;
    @Column(name = "entretiens")
    private String entretiens;
    @Column(name = "competence")
    private String competence;
    @Column(name = "decouverte")
    private String decouverte;*/

    public Stage() {

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

    /*public String getDate() {
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

    public String getGratification() {
        return gratification;
    }

    public void setGratification(String gratification) {
        this.gratification = gratification;
    }

    public String getParcours() {
        return parcours;
    }

    public void setParcours(String parcours) {
        this.parcours = parcours;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getEntretiens() {
        return entretiens;
    }

    public void setEntretiens(String entretiens) {
        this.entretiens = entretiens;
    }

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    public String getDecouverte() {
        return decouverte;
    }

    public void setDecouverte(String decouverte) {
        this.decouverte = decouverte;
    }*/
}
