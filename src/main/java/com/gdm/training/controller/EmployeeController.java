package com.gdm.training.controller;

import com.gdm.training.dao.EmployeeDao;
import com.gdm.training.exception.InvalidIdException;
import com.gdm.training.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
public class EmployeeController {

    @Autowired(required = true)
            @Qualifier("e")
    EmployeeDao dao;

    //private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

//    @Autowired
//    @Qualifier("employeeValidator")
//    private Validator validator;

    private static String PAGE = "register";

//    @InitBinder
//    private void initBinder(WebDataBinder binder) {
//        binder.setValidator(validator);
//    }

    @RequestMapping("/")
    public String indexPage() {
        return "index";
    }

    @RequestMapping("/registerForm")
    public String registerForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("validationModel", employee);
        return "register";
    }

    @RequestMapping(value = "/registerEmp", method = RequestMethod.POST)
    public String validate(@ModelAttribute("validationModel") @Valid Employee employee, Errors errors) throws InvalidIdException {

//        if(employee.getId() <= 0) {
//            throw new InvalidIdException("Invalid id provide a valid id");
//        }

        System.out.println("Errors = " + errors.hasErrors());
        System.out.println("Errors = " + errors.getAllErrors().toString());

        if(!errors.hasErrors()){
           int result =  dao.register(employee);
        }
        return "register";
    }

//    @RequestMapping(value = "/insert", method = RequestMethod.POST)
//    public String insert(@Valid @ModelAttribute("validationModel") Employee employee, Model model, Errors errors) {
//        System.out.println(employee.getSalary());
//        System.out.println("Errors = " + errors.hasErrors());
//        System.out.println("Errors = " + errors.getAllErrors().toString());
//        if(errors.hasErrors()) {
//            logger.info("Error page");
//            model.addAttribute("message", "Error page - " + employee.getName());
//            return "error";
//        } else {
//            logger.info("Employee validation success");
//            model.addAttribute("message", "Successfully Registered - " + employee.getName());
//
//            int result = dao.register(employee);
//            if (result == 1) {
//                model.addAttribute("message", "Registration success");
//                return "result";
//            } else {
//                model.addAttribute("message", "Unable to Register Employee details");
//                return "error";
//            }
//        }
//    }

    @RequestMapping("/updateForm")
    public String updateForm() {
        return "update";
    }

    @RequestMapping(value = "/update")
    public String update(@RequestParam(required = true) int id, @RequestParam int salary, Model model)  {
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
    public String selectForm() {
        return "select";
    }

    @RequestMapping("/select")
    public String select(@RequestParam int id, Model model) {
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
    public String selectAllEmployees(Model model) {
        List<Employee> employeeList = dao.getAllEmployees();
        model.addAttribute("empList", employeeList);
        return "displayAll";
    }
}
