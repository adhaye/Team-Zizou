package com.stage.servicestage.controller;

import java.util.List;


import com.stage.servicestage.model.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RestController;

import com.stage.servicestage.dao.ConnexionInscriptionDao;
import com.stage.servicestage.dao.StageDao;
import com.stage.servicestage.model.User;

import javax.servlet.http.HttpSession;

@Controller
public class Connexion {

    @Autowired
    private ConnexionInscriptionDao connexionInscriptionDao;
    @Autowired
    private StageDao stageDao;



    @RequestMapping(value="/connexion", method={RequestMethod.POST,RequestMethod.GET})
    public String Login(@ModelAttribute(name="connexionForm") User user, Model model, HttpServletRequest request) {
        String email = user.getEmail();
        String password = user.getPassword();
        String authentification = connexionInscriptionDao.authentificationUser(email);
        if (authentification!=null) {
            if (authentification.equals(password)) {
                String username = connexionInscriptionDao.Username(email);
                Integer idUser = connexionInscriptionDao.idUser(email);
                Integer type = connexionInscriptionDao.Type(email);


                HttpSession session = request.getSession(true);
                session.setAttribute("utilisateur", username);
                session.setAttribute("idUser", idUser);
                session.setAttribute("type", type);
                session.setAttribute("email", email);


                List<Stage> listeStage = stageDao.findAllByOrderByIdStageDesc();
                model.addAttribute("list", listeStage);
                String type1 = type.toString();
                model.addAttribute("type", type1);
                return "accueil";
            }
            else {
                return "connexion";
            }
        }
        return "connexion";
    }

}
