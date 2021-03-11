package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.UserService;
import com.codegym.validators.PhoneNumberValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@Validated
public class UserController {
    @GetMapping("/index")
    public ModelAndView form(){
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/index")
    public ModelAndView checkValidate(@Validated @ModelAttribute ("user") User user, BindingResult bindingResult, PhoneNumberValidator phoneNumberValidator){
        if (bindingResult.hasErrors()){
            return new ModelAndView("index");
        } else {
            return new ModelAndView("success");
        }
    }
}
