package com.stage.servicestage.controller;

import com.stage.servicestage.dao.ConnexionInscriptionDao;
import com.stage.servicestage.dao.StageDao;
import com.stage.servicestage.model.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;



import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import com.stage.servicestage.model.User;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@Controller
public class Accueil {

    @Autowired
    private StageDao stageDao;
    @Autowired
    private ConnexionInscriptionDao ConnexionInscriptionDao;

    //@RequestMapping(value="/inscription", method=RequestMethod.GET)
    //public String getLoginForm() {return "subscribe";}

    @RequestMapping(value="/accueil", method={RequestMethod.POST,RequestMethod.GET})
    public String affichage( HttpServletRequest request, Model model) {
        HttpSession session=request.getSession(false);
        if (session==null){
                return "connexion";
        }


        List<Stage> listeStage = stageDao.findAll();
        model.addAttribute("list", listeStage);
        return "accueil";

    }

    @RequestMapping(value="/deconnexion", method={RequestMethod.POST,RequestMethod.GET})
    public String déconnexion(HttpServletRequest request) {
        HttpSession session=request.getSession(false);
        if (session==null){
            return "connexion";
        }
        else{
            session.invalidate();
            return "connexion";
        }
    }


}
