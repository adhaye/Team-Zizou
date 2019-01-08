package com.stage.servicestage.controller;

import com.stage.servicestage.dao.StageDao;
import com.stage.servicestage.model.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


import java.util.List;
import com.stage.servicestage.model.Stage;


@Controller
public class StageController {

    @Autowired
    private StageDao stageDao;

    @RequestMapping(value="/ajouterStage", method={RequestMethod.POST, RequestMethod.GET})
    public String Login(@ModelAttribute(name="ajouterStage") Stage stage, Model model) {
        //int id_stage = stage.getIdStage();
        String poste = stage.getPoste();
        String entreprise = stage.getEntreprise();
        String localisation = stage.getLocalisation();

        if (poste!=null && entreprise!=null && localisation!=null) {
            //stageDao.insertStageBdd(id_stage, poste, entreprise, localisation);
            //stageDao.insertStageBdd(poste, entreprise, localisation);
            stageDao.save(stage);

            return "accueil";
        }

        return "ajouterStage";
    }

}
