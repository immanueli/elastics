package com.imma.elastics.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/hello")
    public ModelAndView hello(Model model){
        ModelAndView index = new ModelAndView("index");
        model.addAttribute("name","imma");
        return index;
    }
}