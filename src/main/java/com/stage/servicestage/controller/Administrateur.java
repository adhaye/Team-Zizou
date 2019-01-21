package com.stage.servicestage.controller;

import com.stage.servicestage.dao.ConnexionInscriptionDao;
import com.stage.servicestage.dao.StageDao;
import com.stage.servicestage.model.Stage;
import com.stage.servicestage.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
    @Autowired
    private StageDao stageDao;

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
            Integer type = (Integer)session.getAttribute("type");
            String type1 = type.toString();
            model.addAttribute("type", type1);
            List<User> listeUser = connexionInscriptionDao.findByType(0);
            model.addAttribute("listeUser", listeUser);

            List<Stage> listeStage = stageDao.findAllByOrderByIdStageDesc();
            model.addAttribute("listeStage", listeStage);

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

        List<User> listeUser = connexionInscriptionDao.findByType(0);
        model.addAttribute("listeUser", listeUser);

        List<Stage> listeStage = stageDao.findAllByOrderByIdStageDesc();
        model.addAttribute("listeStage", listeStage);

        return "administrateur";
    }

    @RequestMapping(value = "/deleteStage", method = {RequestMethod.POST, RequestMethod.GET})
    public String DeleteStage(@RequestParam("id_stage") int id_stage, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "connexion";
        }
        Optional<Stage> option = stageDao.findById(id_stage);
        Stage stage = option.get();
        stageDao.delete(stage);

        List<Stage> listeStage = stageDao.findAllByOrderByIdStageDesc();
        model.addAttribute("listeStage", listeStage);

        List<User> listeUser = connexionInscriptionDao.findAll();
        model.addAttribute("listeUser", listeUser);

        return "administrateur";
    }

}
