package com.mgt.plat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * package name：com.mgt.plat.controller
 * description：
 * user：JupSat
 * modification time：2023-03-13 22:29
 * modified content：
 **/
@Controller
public class ThymeleafController {

    @GetMapping("/thymeleaf")
    public String test(Model model){
        model.addAttribute("msg","Hello Thymeleaf!");
        return "test";
    }
}
