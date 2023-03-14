package com.mgt.plat.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * package name：com.mgt.plat.controller
 * description：
 * user：JupSat
 * modification time：2023-03-13 22:29
 * modified content：
 **/
@RestController
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @GetMapping("/test")
    public ModelAndView test(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("th");
        modelAndView.addObject("msg","测试thymeleaf");
        return modelAndView;
     }
}
