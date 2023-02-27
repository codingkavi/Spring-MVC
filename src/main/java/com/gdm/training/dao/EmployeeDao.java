package com.gdm.training.dao;

import com.gdm.training.model.Employee;
import com.gdm.training.util.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Component
public class EmployeeDao {

    @Autowired
    private JdbcTemplate template;     //gives prepared statement object



    public int register(Employee e) throws SQLException {

        Object[] args = {e.getId(),e.getName(),e.getSalary() };
        template.update("insert into Employee values(?,?,?)",args);
        return 1;
    }

    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> list = new ArrayList<>();
        list =  template.query("select * from Employee",
                new RowMapper<Employee>() {

                    @Override
                    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        int salary = rs.getInt("salary");
                        Employee e = new Employee(id, name, salary);
                        return e;
                    }
                });
        return list;
    }

    public int updateSalary(int id,int salary) throws SQLException {

        Object[] args = {id,salary};
        int i = template.update("update Employee set salary = ? where id = ?",args);
        return i;
    }

    public Employee selectById(int id) throws SQLException {

        Object[] args = {id};
        Employee employee = template.queryForObject("select * from Employee where id = ?",
                (rs, rowNum) -> {
                    int id1 = rs.getInt("id");
                    String name = rs.getString("name");
                    int salary = rs.getInt("salary");
                    Employee e = new Employee(id1, name, salary);
                    return e;
                }, args);
        return employee;
    }
}
