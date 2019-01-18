package com.stage.servicestage.controller;

import com.stage.servicestage.dao.ConnexionInscriptionDao;
import com.stage.servicestage.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;


@Controller
public class Administrateur {

    @Autowired
    private ConnexionInscriptionDao connexionInscriptionDao;

    @RequestMapping(value="/administrateur", method={RequestMethod.POST,RequestMethod.GET})
    public String administrateur(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);

        if (session==null) {
            return "connexion";
        }
        else if ((int) session.getAttribute("type")==0){
            return "accueil";

        }
        else{
            String type = (String)session.getAttribute("type");
            model.addAttribute("type", type);
            List<User> listeUser = connexionInscriptionDao.findAll();
            model.addAttribute("listeUser", listeUser);
            return "administrateur";
        }
    }


    @RequestMapping(value = "/deleteUser", method = {RequestMethod.POST, RequestMethod.GET})
    public String DeleteUser(@RequestParam("id_user") Integer id_user, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "connexion";
        }

        Optional<User> option = connexionInscriptionDao.findById(id_user);
        User user = option.get();
        connexionInscriptionDao.delete(user);
        List<User> listeUser = connexionInscriptionDao.findAll();
        model.addAttribute("listeUser", listeUser);
        return "administrateur";


    }
}
