package com.gdm.training.servlet;

import com.gdm.training.dao.EmployeeDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class RegisterServlet extends HttpServlet {

    public void service( HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        int id = Integer.parseInt(req.getParameter("empId"));
        String name = req.getParameter("empName");
        int salary = Integer.parseInt(req.getParameter("empSal"));
        System.out.println(id +" " + name + " " + salary);

        EmployeeDao dao = new EmployeeDao();
        try {
            int result = dao.register(id, name, salary);
            if(result == 1) {
                req.setAttribute("message", "Registered Successfully");
                RequestDispatcher rd = req.getRequestDispatcher("result.jsp");
                rd.forward(req,res);
            } else {
                req.setAttribute("message","unable to register");
                RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
                rd.forward(req,res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
