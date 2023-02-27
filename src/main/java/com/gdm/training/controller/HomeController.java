package com.gdm.training.controller;

import com.gdm.training.dao.EmployeeDao;
import com.gdm.training.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.SQLException;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    EmployeeDao dao;

    @RequestMapping("/")
    public String indexPage() {
        return "index";
    }

    @RequestMapping("/registerForm")
    public String registerForm() {
        return "register";
    }

    @RequestMapping(value = "/insert")
    public String insert(@ModelAttribute Employee employee, Model model) throws SQLException {
        System.out.println(employee.getSalary());
        int result = dao.register(employee);
        if (result == 1) {
            model.addAttribute("message", "Registration success");
            return "result";
        } else {
            model.addAttribute("message", "Unable to Register Employee details");
            return "error";
        }
    }

    @RequestMapping("/updateForm")
    public String updateForm() {
        return "update";
    }

    @RequestMapping(value = "/update")
    public String update(@RequestParam int id, @RequestParam int salary, Model model) throws SQLException {
        int isUpdated = dao.updateSalary(id, salary);
        if (isUpdated == 1) {
            model.addAttribute("message", "Updated Successfully");
            return "result";
        } else {
            model.addAttribute("message", "Unable to update salary");
            return "error";
        }
    }

    @RequestMapping("/selectByIdForm")
    public String selectById() {
        return "select";
    }

    @RequestMapping("/select")
    public String selectById(@RequestParam int id, Model model) throws SQLException {
        Employee employee = dao.selectById(id);
        System.out.println(employee.getSalary());
        model.addAttribute("emp",employee);
        return "display";
    }

    @RequestMapping("/selectForm")
    public String selectAll() {
        return "selectAll";
    }

    @RequestMapping("/all")
    public String selectAllEmployees(Model model) throws SQLException {
        List<Employee> employeeList = dao.getAllEmployees();
        model.addAttribute("empList", employeeList);
        return "displayAll";
    }
}
