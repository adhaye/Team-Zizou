package com.stage.servicestage.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MyErrorController implements ErrorController{

    @RequestMapping("/error")
    public String handleError() {
        return "error";
    }


    @Override
    public String getErrorPath() {
        return "/error";
    }

}
