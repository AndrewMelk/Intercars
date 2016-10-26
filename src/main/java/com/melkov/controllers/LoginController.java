package com.melkov.controllers;

import com.melkov.domain.User;
import com.melkov.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by andrew on 26.10.16.
 */
@Controller("/login")
public class LoginController {

    Logger logger = Logger.getLogger(getClass().toString());

    @Autowired
    UserService userService;

    @RequestMapping(value = "/loginform")
    public ModelAndView login(@ModelAttribute User user){
        logger.log(Level.SEVERE, "in /login");
        return new ModelAndView("login");

    }

    @RequestMapping(value = "/loginUser",method = RequestMethod.POST)
    public String loginUser(@ModelAttribute User user){
        logger.log(Level.SEVERE,"in loginUser action");
        String page;
        if (userService.validUser(user)){

            page = "redirect:/getList";
        }else {
            page = "redirect:/loginform";

        }
        return page;
    }
}
