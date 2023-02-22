package com.gdm.training.servlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class InboxServlet extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");
        Cookie cookies[] = req.getCookies();
        String loggedInUser = null;

        if(cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("user")) {
                    loggedInUser = c.getValue();
                }
            }
        }

        if(loggedInUser == null || loggedInUser.isEmpty() ) {
            req.setAttribute("errorMessage","Please login");
            res.sendRedirect("login.jsp");
        } else {
            pw.write("<h1>Welcome to your Inbox " + loggedInUser + "</h1>");
            pw.write("<a href='logout'>Logout</a>");
        }


    }
}
