package com.dev.repositories;

import com.dev.models.Employee;
import com.dev.utilis.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface UserRepo extends CrudRepo<Employee> {

    Employee add(Employee employee);

    Employee getById(Integer id);

    Employee getByName(String name);

    List<Employee> getAll();

    void update(Employee employee);

    void delete(Integer id);
}


//    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
//
//    @Override
//    public Employee add(Employee employee) {
//        return null;
//    }
//
//    @Override
//    public Employee getById(Integer id) {
//        return null;
//    }
//
//    public Employee getByName(String name)
//    {
//
//        try (Connection conn = cu.getConnection()) {
//
//            String sql = "select * from employees where lastname = ?";
//
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, name);
//
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                Employee em = new Employee(
//                        rs.getString("eid"),
//                        rs.getString("firstname"),
//                        rs.getString("lastname"),
//                        rs.getInt("totalbenefit")
//                );
//                return em;
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        // try-with-resources - automatically closes resources after execution
////        finally {
////            conn.close();
////        }
//
//        return null;
//
//    }
//
//    @Override
//    public List<Employee> getAll() {
//
//        List<Employee> employees = new ArrayList<>();
//
//        try (Connection conn = cu.getConnection()) {
//
//            // we will need to use a join on books and authors to get all data needed
//            String sql = "select * from employees";
//
//            PreparedStatement ps = conn.prepareStatement(sql);
//
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                // For each record we need to create an Author Object AND a Book Object
//                Employee ep = new Employee();
//                ep.setEid(rs.getString("eid"));
//                ep.setFirstname(rs.getString("firstname"));
//                ep.setLastname(rs.getString("lastname"));
//                ep.setTotBenefits(rs.getInt("totalbenefit"));
//
//                employees.add(ep);
//            }
//
//            return employees;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    @Override
//    public void update(Employee employee) {
//
//    }
//
//    @Override
//    public void delete(Integer id) {
//
//    }

