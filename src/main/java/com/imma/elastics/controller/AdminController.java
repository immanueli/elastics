package com.imma.elastics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台管理
 */
@Controller
public class AdminController {
    /**
     * 后台管理中心
     * @return
     */
    @GetMapping("/center")
    public String adminCenter() {
        return "admin/center";
    }

    @GetMapping("/welcome")
    public String adminWelcome() {
        return "admin/welcome";
    }
}
