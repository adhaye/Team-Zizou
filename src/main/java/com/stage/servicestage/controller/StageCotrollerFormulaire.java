/*package com.stage.servicestage.controller;

import com.stage.servicestage.dao.StageDao;
import com.stage.servicestage.model.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StageCotrollerFormulaire {

    @Autowired
    private StageDao stageDao;

    @GetMapping(value = "/AjouterStage")
    public String formStage(Model model){
        model.addAttribute("stage",new Stage());
        return "AjouterStage";
    }

    @PostMapping(value = "/AjouterStage")
    public List<Stage> stageSubmit(@ModelAttribute Stage stage) {

        return stageDao.findAll();
    }
}
*/