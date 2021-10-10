package com.dev.repositories;

import com.dev.models.Employee;
import com.dev.utilis.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeesRepo implements CrudRepo<Employee> {

    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    @Override
    public Employee add(Employee employee) {
        return null;
    }

    @Override
    public Employee getById(Integer id) {
        return null;
    }


    public Employee getById(String eid) {
        try (Connection conn = cu.getConnection()) {

            String sql = "select * from employees where eid = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, eid);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Employee e = new Employee(
                        rs.getString("eid"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getInt("totalbenefit"),
                        rs.getInt("adminlevel"),
                        rs.getInt("depart")
                );
                return e;
            }

        } catch (SQLException s) {
            s.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> getAll() {

        return null;
    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void delete(Integer id) {

    }
}
