package com.gdm.training.dao;

import com.gdm.training.model.Employee;
import com.gdm.training.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    public int register(int id,String name,int salary) throws SQLException {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement("insert into Employee values(?,?,?)");
        ps.setInt(1,id);
        ps.setString(2,name);
        ps.setInt(3,salary);
        ps.executeUpdate();
        return 1;
    }

    public List<Employee> getAllEmployees() throws SQLException {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement("Select * from Employee");
        ResultSet rs = ps.executeQuery();
        List<Employee> list = new ArrayList<>();

        while(rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int salary = rs.getInt("salary");
            Employee employee = new Employee(id,name,salary);
            list.add(employee);

        }
        return list;
    }

    public int updateSalary(int id,int salary) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement("update Employee set salary = ? where id = ?");
        ps.setInt(1,salary);
        ps.setInt(2,id);
        ps.executeUpdate();
        return 1;
    }
}
