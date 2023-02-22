package com.gdm.training.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Cookie c = new Cookie("user",null);
        res.addCookie(c);
        req.setAttribute("errorMessage","logout success");
        RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
        rd.forward(req,res);
    }
}
