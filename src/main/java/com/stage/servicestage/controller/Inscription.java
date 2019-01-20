package com.stage.servicestage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stage.servicestage.dao.ConnexionInscriptionDao;
import com.stage.servicestage.model.User;


@Controller
public class Inscription {
    @Autowired
    private ConnexionInscriptionDao connexionInscriptionDao;

    @RequestMapping(value="/inscription", method={RequestMethod.POST, RequestMethod.GET})
    public String Login(@ModelAttribute(name="inscriptionForm") User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        String confirmPassword = user.getConfirmPassword();
        String username = user.getUsername();
        user.setType(0);

        if (email!=null && password!=null && username!=null) {
            if (email.substring(email.length()-8, email.length()).equals("@isep.fr") && password.equals(confirmPassword)) {
                connexionInscriptionDao.save(user);
                return "connexion";
            }
        }
        return "inscription";
    }

}
