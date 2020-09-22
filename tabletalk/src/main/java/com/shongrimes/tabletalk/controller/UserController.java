package com.shongrimes.tabletalk.controller;

import com.shongrimes.tabletalk.data.UserData;
import com.shongrimes.tabletalk.data.UserRepository;
import com.shongrimes.tabletalk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private UserData userData;

    @GetMapping("register")
    public String displayRegistrationPage(Model model){

        model.addAttribute("title", "Registration");
        model.addAttribute(new User());
        return "user/register";
    }

    @PostMapping("register")
    public String processRegistrationPage(@ModelAttribute @Valid User newUser, Errors errors, Model model){

        if(errors.hasErrors()){
            model.addAttribute("title", "Registration");
            model.addAttribute(new User());
            return "user/register";
        }

        userRepository.save(newUser);
        return "redirect:login";
    }

    @GetMapping("login")
    public String displayLoginPage(Model model){

        model.addAttribute("title", "Login");
        model.addAttribute(new User());
        return "user/login";
    }

    @PostMapping("login")
    public String processLogin(@ModelAttribute @Valid User validUser, Errors errors, Model model){

        if(errors.hasErrors()){
            model.addAttribute("title", "Login");
            model.addAttribute(new User());
            return "user/login";
        }

        userData.addUser(validUser);
        return "redirect:";
     }
}
