package com.stage.servicestage.controller;

import com.stage.servicestage.dao.ConnexionInscriptionDao;
import com.stage.servicestage.dao.StageDao;
import com.stage.servicestage.model.Stage;
import com.stage.servicestage.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class Profil {

    @Autowired
    private ConnexionInscriptionDao connexionInscriptionDao;
    @Autowired
    private StageDao stageDao;

    @RequestMapping(value = "/monProfil", method = {RequestMethod.POST, RequestMethod.GET})
    public String ModifierProfil(@ModelAttribute(name = "updateForm") User user, Model model, HttpServletRequest request) {


        HttpSession session=request.getSession(false);
        if (session==null){
            return "connexion";
        }

        int id_user = (int)request.getSession().getAttribute("idUser");
        String emailUpdate = user.getEmail();
        String passwordUpdate = user.getPassword();
        String usernameUpdate = user.getUsername();

        if (usernameUpdate != null || emailUpdate != null || passwordUpdate != null) {
            connexionInscriptionDao.setUsername(usernameUpdate, id_user);
            session.setAttribute("utilisateur", usernameUpdate);

            connexionInscriptionDao.setEmail(emailUpdate, id_user);
            session.setAttribute("email", emailUpdate);

            connexionInscriptionDao.setPassword(passwordUpdate, id_user);
            session.setAttribute("password", passwordUpdate);

        }


        String username = (String)request.getSession().getAttribute("utilisateur");
        Optional<User> option = connexionInscriptionDao.findById(id_user);
        user = option.get();
        List<Stage> listeStage = stageDao.findByIdUser(id_user);
        model.addAttribute("listeStage", listeStage);
        model.addAttribute("utilisateur", username);



        return "monProfil";

    }

/*
    @RequestMapping(value = "/monProfil", method = {RequestMethod.POST, RequestMethod.GET})
    public String ModifierNom(@ModelAttribute(name = "updateForm") User user, Model model, HttpServletRequest request) {


        HttpSession session=request.getSession(false);
        if (session==null){
            return "connexion";
        }

        int id_user = (int)request.getSession().getAttribute("idUser");
        String usernameUpdate = user.getUsername();

        if (usernameUpdate != null ) {
            connexionInscriptionDao.setUsername(usernameUpdate, id_user);
            session.setAttribute("utilisateur", usernameUpdate);
        }


        String username = (String)request.getSession().getAttribute("utilisateur");
        Optional<User> option = connexionInscriptionDao.findById(id_user);
        user = option.get();
        List<Stage> listeStage = stageDao.findByIdUser(id_user);
        model.addAttribute("listeStage", listeStage);
        model.addAttribute("utilisateur", username);



        return "monProfil";

    }

    @RequestMapping(value = "/monProfil", method = {RequestMethod.POST, RequestMethod.GET})
    public String ModifierEmail(@ModelAttribute(name = "updateForm2") User user, Model model, HttpServletRequest request) {


        HttpSession session=request.getSession(false);
        if (session==null){
            return "connexion";
        }

        int id_user = (int)request.getSession().getAttribute("idUser");
        String emailUpdate = user.getEmail();


        if (emailUpdate != null) {
            connexionInscriptionDao.setEmail(emailUpdate, id_user);
            session.setAttribute("email", emailUpdate);
        }


        String username = (String)request.getSession().getAttribute("utilisateur");
        Optional<User> option = connexionInscriptionDao.findById(id_user);
        user = option.get();
        List<Stage> listeStage = stageDao.findByIdUser(id_user);
        model.addAttribute("listeStage", listeStage);
        model.addAttribute("utilisateur", username);



        return "monProfil";

    }

    @RequestMapping(value = "/monProfil", method = {RequestMethod.POST, RequestMethod.GET})
    public String ModifierPassword(@ModelAttribute(name = "updateForm3") User user, Model model, HttpServletRequest request) {


        HttpSession session=request.getSession(false);
        if (session==null){
            return "connexion";
        }

        int id_user = (int)request.getSession().getAttribute("idUser");
        String passwordUpdate = user.getPassword();


        if ( passwordUpdate != null) {
            connexionInscriptionDao.setPassword(passwordUpdate, id_user);
            session.setAttribute("password", passwordUpdate);
        }


        String username = (String)request.getSession().getAttribute("utilisateur");
        Optional<User> option = connexionInscriptionDao.findById(id_user);
        user = option.get();
        List<Stage> listeStage = stageDao.findByIdUser(id_user);
        model.addAttribute("listeStage", listeStage);
        model.addAttribute("utilisateur", username);



        return "monProfil";

    }*/



}
