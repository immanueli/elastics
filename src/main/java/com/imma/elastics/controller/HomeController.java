package com.imma.elastics.controller;

import com.imma.elastics.base.ApiResponse;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
    @GetMapping("/hello")
    public ModelAndView hello(Model model){
        ModelAndView index = new ModelAndView("index");
        model.addAttribute("name","imma");
        return index;
    }

    @GetMapping("/getMessage")
    public ApiResponse getMessage(){
        return ApiResponse.ofMessage(200,"请求成功");
    }

}
