package com.gdm.training.mapper;

import com.gdm.training.model.Employee;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        int salary = rs.getInt("salary");
        Employee e = new Employee(id,name,salary);
        return e;
    }
}
