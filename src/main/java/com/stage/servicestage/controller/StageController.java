package com.stage.servicestage.controller;

import com.stage.servicestage.dao.ConnexionInscriptionDao;
import com.stage.servicestage.dao.StageDao;
import com.stage.servicestage.model.Stage;
import com.stage.servicestage.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


import java.util.List;
import java.util.Optional;

import com.stage.servicestage.model.Stage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class StageController {

    @Autowired
    private StageDao stageDao;

    @Autowired
    private ConnexionInscriptionDao connexionInscriptionDao;

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
        Integer idUser = (int)session.getAttribute("idUser");
        stage.setIdUser(idUser);

        if (poste != null && entreprise != null && localisation != null && date != null && duree != null && commentaire != null && gratification != null && parcours != null && note != null) {
            //stageDao.insertStageBdd(id_stage, poste, entreprise, localisation);
            //stageDao.insertStageBdd(poste, entreprise, localisation);
            stageDao.save(stage);

            List<Stage> listeStage = stageDao.findAll();
            model.addAttribute("list", listeStage);

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
            System.out.println("4");
        }

        List<Stage> listeStage = stageDao.findAll();
        model.addAttribute("listeStage", listeStage);

        return "afficherStage";
    }

    @RequestMapping(value = "/rechercherStage", method = {RequestMethod.POST, RequestMethod.GET})
    public String Recherche(Model model) {

        Stage stage = new Stage();
        model.addAttribute("stage", stage);

        return "rechercherStage";

    }


    @RequestMapping(value = "/classementStage", method = {RequestMethod.POST, RequestMethod.GET})
    public String Classement(@ModelAttribute(name = "classementStage") Stage stage, Model model){

        List<Stage> listeStage = stageDao.findAllByOrderByGratificationDesc();
        model.addAttribute("listeStage", listeStage);

        List<Stage> listeStage2 = stageDao.findAllByOrderByNoteDesc();
        model.addAttribute("listeStage2", listeStage2);

        return "classementStage";

    }

    @RequestMapping(value = "/monProfile", method = {RequestMethod.POST, RequestMethod.GET})
    public String ModifierProfile(@ModelAttribute(name = "monProfile") Stage stage, Model model, HttpServletRequest request) {

        int id_user = (int)request.getSession().getAttribute("idUser");
        Optional<User> option = connexionInscriptionDao.findById(id_user);
        User user = option.get();
        //List<Stage> listeStage = stageDao.findAllByiDUser();
        //model.addAttribute("listeStage", listeStage);

        return "monProfile";

    }

}