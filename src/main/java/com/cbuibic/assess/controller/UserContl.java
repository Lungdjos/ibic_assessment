package com.cbuibic.assess.controller;

import ch.qos.logback.core.model.Model;
import com.cbuibic.assess.dto.UserDto;
import com.cbuibic.assess.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registration")
public class UserContl {

    @Autowired
    private UserService userService;


    /**
     *
     * @return
     */
    @ModelAttribute("user")
    public UserDto userDto() {
        return new UserDto();
    }

    /**
     *
     * @return
     */
    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }


    /**
     *
     * @param registrationDto
     * @return
     * @throws Exception
     */

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserDto registrationDto) throws Exception {
        try {
            userService.creatNewUser(registrationDto);
            return "redirect:/registration?success";
        } catch (Exception e){
            return "redirect:/registration?error";
        }
    }

    /**
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) throws Exception {
        userService.deleteUser(id);
        return "redirect:/index";
    }
}
