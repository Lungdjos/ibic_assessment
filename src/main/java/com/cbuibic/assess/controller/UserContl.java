package com.cbuibic.assess.controller;

import com.cbuibic.assess.dto.UserDto;
import com.cbuibic.assess.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserContl {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserDto userDto() {
        return new UserDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserDto registrationDto) throws Exception {
        try {
            userService.creatNewUser(registrationDto);
            return "redirect:/registration?success";
        } catch (Exception e){
            return "redirect:/registration?error";
        }
    }
}
