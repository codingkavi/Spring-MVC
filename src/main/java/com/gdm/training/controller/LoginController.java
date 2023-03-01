package com.gdm.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller

public class LoginController {

    @RequestMapping("/loginForm")
    public String login() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(@RequestParam("username") String user, @RequestParam String password, Model model, HttpSession session) {
        if(user.equals(password)) {
            session.setAttribute("xyz",user);
        } else {
            model.addAttribute("errorMessage","Login failed");
            return "login";
        }
        return "loggedIn";
    }

    @RequestMapping("/inbox")
    public String inbox(HttpSession session, Model model) {
        String username = (String) session.getAttribute("xyz");
        if(username == null) {
            model.addAttribute("errorMessage","Login First");
            return "login";
        } else {
            model.addAttribute("username",username);
            return "inbox";
        }

    }



    @RequestMapping("/logout")
    public String logout(HttpSession session,Model model) {
        session.invalidate();
        model.addAttribute("errorMessage","Logout Success");
        return "login";
    }
}
