package com.openclassrooms.P12.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ProjetController {


    private ModelAndView mav;
    @RequestMapping(value ="/projet",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showprojet(Model model) {
        mav = new ModelAndView("/projet");
        return mav;
    }
}
