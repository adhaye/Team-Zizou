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
    public String ModifierProfil(@ModelAttribute(name = "monProfil") Stage stage, Model model, HttpServletRequest request) {


        HttpSession session=request.getSession(false);
        if (session==null){
            return "connexion";
        }

        int id_user = (int)request.getSession().getAttribute("idUser");
        Optional<User> option = connexionInscriptionDao.findById(id_user);
        User user = option.get();
        List<Stage> listeStage = stageDao.findByIdUser(id_user);
        model.addAttribute("listeStage", listeStage);



        return "monProfil";

    }
}
