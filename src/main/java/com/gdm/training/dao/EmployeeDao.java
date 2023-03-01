package com.gdm.training.dao;

import com.gdm.training.mapper.EmployeeMapper;
import com.gdm.training.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;


@Component
public class EmployeeDao {

    @Autowired
    private JdbcTemplate template;     //gives prepared statement object



    public int register(Employee e){

        Object[] args = {e.getId(),e.getName(),e.getSalary() };
        template.update("insert into Employee values(?,?,?)",args);
        return 1;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> list;
        list =  template.query("select * from Employee",new EmployeeMapper());
        return list;
    }

    public int updateSalary(int id,int salary) {

        Object[] args = {salary,id};
        int result = template.update("update Employee set salary = ? where id = ?",args);
        return result;
    }

    public Employee selectById(int id)  {

        Object[] args = {id};
        Employee employee = template.queryForObject("select * from Employee where id = ?",
                new EmployeeMapper(),args);
        return employee;
    }
}
