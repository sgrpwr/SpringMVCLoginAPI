package com.sagar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(@ModelAttribute("objUser") UserLogin user){
        return "login";
    }

    @RequestMapping("/login-panel")
    public String home(@ModelAttribute("objUser") UserLogin login, Model model){
        if(login.getUserName().contentEquals("admin") &&
                login.getUserPasswd().contentEquals("123")){
            return "home";
        }
        else {
            model.addAttribute("msg", "Invalid!!");
            return "login";
        }
    }
}
