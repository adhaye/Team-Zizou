package com.stage.servicestage.controller;

import com.stage.servicestage.dao.StageDao;
import com.stage.servicestage.model.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


import java.util.List;
import com.stage.servicestage.model.Stage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class StageController {

    @Autowired
    private StageDao stageDao;

    @RequestMapping(value = "/ajouterStage", method = {RequestMethod.POST, RequestMethod.GET})
    public String AjouterSatge(@ModelAttribute(name = "ajouterStage") Stage stage, Model model, HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        if (session==null){
            return "connexion";
        }

        String poste = stage.getPoste();
        String entreprise = stage.getEntreprise();
        String localisation = stage.getLocalisation();
        String date = stage.getDate();
        String duree = stage.getDuree();
        String commentaire = stage.getCommentaire();
        Integer gratification = stage.getGratification();
        String parcours = stage.getParcours();
        Integer note = stage.getNote();

        if (poste != null && entreprise != null && localisation != null && date != null && duree != null && commentaire != null && gratification != null && parcours != null && note != null) {
            //stageDao.insertStageBdd(id_stage, poste, entreprise, localisation);
            //stageDao.insertStageBdd(poste, entreprise, localisation);
            stageDao.save(stage);

            return "accueil";
        }

        return "ajouterStage";
    }

    @RequestMapping(value = "/afficherStage", method = {RequestMethod.POST, RequestMethod.GET})
    public String Affiche(@ModelAttribute(name = "afficherStage") Stage stage, Model model, HttpServletRequest request) {

        HttpSession session=request.getSession(false);
        if (session==null){
            return "connexion";
        }
        /*String poste = stage.getPoste();
        String entreprise = stage.getEntreprise();
        String localisation = stage.getLocalisation();
        String date = stage.getDate();
        String duree = stage.getDuree();
        String commentaire = stage.getCommentaire();
        Integer gratification = stage.getGratification();
        String parcours = stage.getParcours();
        Integer note = stage.getNote();
        System.out.println(entreprise);
        System.out.println(poste);*/



        if (stage.getPoste()!="") {
            if (stage.getEntreprise()=="") {
                List<Stage> listeStage = stageDao.findByPoste(stage.getPoste());
                model.addAttribute("listeStage", listeStage);
                System.out.println("1");
            } else {
                List<Stage> listeStage = stageDao.findByPosteAndEntreprise(stage.getPoste(), stage.getEntreprise());
                model.addAttribute("listeStage", listeStage);
                System.out.println("2");
            }
        }else {
            if (stage.getEntreprise()!="") {
                List<Stage> listeStage = stageDao.findByEntreprise(stage.getEntreprise());
                model.addAttribute("listeStage", listeStage);
                System.out.println("3");
            }
        }


        if (stage.getPoste()=="" && stage.getEntreprise()=="" ) {
            List<Stage> listeStage = stageDao.findAll();
            model.addAttribute("listeStage", listeStage);
            System.out.println("5");
        }


        return "afficherStage";
    }

    @RequestMapping(value = "/rechercherStage", method = {RequestMethod.POST, RequestMethod.GET})
    public String Recherche(Model model) {

        Stage stage = new Stage();
        model.addAttribute("stage", stage);

        return "rechercherStage";

    }

    /*
    @RequestMapping(value = "/classementStage", method = {RequestMethod.POST, RequestMethod.GET})
    public String Classement(@ModelAttribute(name = "classementStage") Stage stage, Model model){

        List<Stage> listeStage = stageDao.findAllByOrderByGratification(stage);
        model.addAttribute("listeStage", listeStage);

        return "classementStage";

    }
    */


}