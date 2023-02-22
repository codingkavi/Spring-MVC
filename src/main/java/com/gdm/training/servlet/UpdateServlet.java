package com.gdm.training.servlet;

import com.gdm.training.dao.EmployeeDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        int id = Integer.parseInt(req.getParameter("empId"));
        int salary = Integer.parseInt(req.getParameter("empSal"));

        EmployeeDao dao = new EmployeeDao();

        int result = 0;
        try {
            result = dao.updateSalary(id, salary);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (result == 1) {
            req.setAttribute("message", "Employee Salary updated successfully");
            RequestDispatcher rd = req.getRequestDispatcher("result.jsp");
            rd.forward(req, res);
        } else {
            req.setAttribute("message", "Unable to update");
            RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
            rd.forward(req, res);
        }


    }
}
