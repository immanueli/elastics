package com.imma.elastics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    /**
     * 首页
     * @return
     */
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    /**
     * 404页面
     * @return
     */
    @GetMapping("/404")
    public String notFoundPage(){
        return "404";
    }

    /**
     * 500页面
     * @return
     */
    @GetMapping("/500")
    public String internalError(){
        return "500";
    }

    /**
     * 403页面
     * @return
     */
    @GetMapping("/403")
    public String accessError(){
        return "403";
    }

    /**
     * logout页面
     */
    @GetMapping("/logout")
    public String logout(){
        return "logout";
    }


}
