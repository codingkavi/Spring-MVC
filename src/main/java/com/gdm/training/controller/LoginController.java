package com.gdm.training.controller;

import com.gdm.training.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
//@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/loginForm")
    public String initView(Model model) {
        User user = new User();
        model.addAttribute("user",new User());
        return "login";
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String processlogin(@ModelAttribute("user") @Valid User user, Model model, HttpSession session, Errors errors) {
        String username = user.getUsername();
        String password = user.getPassword();
        String message = null;
        System.out.println("Errors = " + errors.hasErrors());
        System.out.println("Errors = " + errors.getAllErrors().toString());
        if (!errors.hasErrors()) {
            if (username != null && !username.equals("") && password != null && !password.equals("")) {
                message = "Welcome" + username;
                model.addAttribute("message", message);
                return "loggedIn";
            } else {
                message = "Wrong username or password";
                model.addAttribute("message", message);
                return "error";
            }
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
