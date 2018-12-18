package com.stage.servicestage.controller;

import com.stage.servicestage.dao.StageDao;
import com.stage.servicestage.model.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


import java.util.List;


@RestController
public class StageController {

    @Autowired
    private StageDao stageDao;

    @GetMapping(value="Stages")
    public List<Stage>listeStages(){

        return stageDao.findAll();
    }

    @GetMapping(value="Stages/{id}")
    public Stage afficherStage(@PathVariable int id){

        return stageDao.findById(id);
    }

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
