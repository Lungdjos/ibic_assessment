package com.cbuibic.assess.controller;

import ch.qos.logback.core.model.Model;
import com.cbuibic.assess.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainContl {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }


    // showing the users
    @GetMapping("/index")
    public String showUserList(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";

    }
}
