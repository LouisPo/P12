package com.openclassrooms.P12.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class BaseController {

    private ModelAndView mav;


    @RequestMapping(value ="/base",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showDicoList(Model model) {
        mav = new ModelAndView("/base");
        return mav;
    }
}
