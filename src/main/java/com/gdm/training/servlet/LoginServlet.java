package com.gdm.training.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String username = req.getParameter("name");
        String password = req.getParameter("password");

        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");

        if(username.equals(password))
        {
            pw.write("<h1>User Login Success</h1>");
            pw.write("<a href='inbox'>Inbox</a>");
            Cookie c = new Cookie("user",username);
            c.setMaxAge(5);
            res.addCookie(c);
        } else {
            req.setAttribute("errorMessage","Invalid User Credentials");
            RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
            rd.forward(req,res);

        }
    }
}
