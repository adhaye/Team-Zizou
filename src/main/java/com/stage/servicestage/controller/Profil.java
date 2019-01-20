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

        Integer type = (Integer)session.getAttribute("type");
        String type1 = type.toString();
        model.addAttribute("type", type1);

        int id_user = (int)request.getSession().getAttribute("idUser");
        String email = (String)request.getSession().getAttribute("email");

        String password = connexionInscriptionDao.authentificationUser(email);
        String username = (String)request.getSession().getAttribute("utilisateur");


        String emailUpdate = user.getEmail();
        String passwordUpdate = user.getPassword();
        String usernameUpdate = user.getUsername();


        if (usernameUpdate != null) {
            if (usernameUpdate != ("")) {
                connexionInscriptionDao.setUsername(usernameUpdate, email, password, id_user);
                session.setAttribute("utilisateur", usernameUpdate);
            }
        }

        if (emailUpdate != null) {
            if (emailUpdate != ("")) {
                connexionInscriptionDao.setUsername(username, emailUpdate, password, id_user);
                session.setAttribute("email", emailUpdate);
            }
        }

        if (passwordUpdate != null) {
            if (passwordUpdate != ("")) {
                connexionInscriptionDao.setUsername(username, email, passwordUpdate, id_user);
                session.setAttribute("password", passwordUpdate);
            }
        }

        Optional<User> option = connexionInscriptionDao.findById(id_user);
        user = option.get();
        List<Stage> listeStage = stageDao.findByIdUser(id_user);
        model.addAttribute("listeStage", listeStage);
        model.addAttribute("utilisateur", username);

        return "monProfil";

    }

}
