package com.gdm.training.servlet;

import com.gdm.training.dao.EmployeeDao;
import com.gdm.training.model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SelectServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {

        EmployeeDao dao = new EmployeeDao();
        try {
            List<Employee> emp = dao.getAllEmployees();
            req.setAttribute("employeeList", emp);

            RequestDispatcher rd = req.getRequestDispatcher("display.jsp");
            rd.forward(req, res);
        } catch (SQLException | ServletException e) {
            e.printStackTrace();
        }

    }
}
