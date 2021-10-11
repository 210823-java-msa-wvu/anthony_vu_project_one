package com.dev.repositories;

import com.dev.models.Application;
import com.dev.models.Employee;
import com.dev.utilis.ConnectionUtil;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationRepo implements CrudRepo<Application>{

    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    @Override
    public Application add(Application a) {

        try (Connection conn = cu.getConnection()) {

            String sql = "insert into application values (default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, a.getEid());
            ps.setString(2, a.getTodayDate());
            ps.setString(3, a.getLocation());
            ps.setString(4, a.getDescription());
            ps.setInt(5, a.getCost());
            ps.setString(6, a.getGrade());
            ps.setString(7, a.getEvent());
            ps.setString(8, a.getJustify());
            ps.setDouble(9, a.getReimbursement());
            ps.setInt(10, a.getDepart());
//            ps.setBoolean(11, a.getAdmin1());
//            ps.setBoolean(12, a.getAdmin2());
//            ps.setBoolean(13, a.getAdmin3());

            ps.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public Application getById(Integer eid) {

        return null;
    }

    public List<Application> getByDepart(Integer depart){
        List<Application> app = new ArrayList<>();

        try (Connection conn = cu.getConnection()) {

            // we will need to use a join on books and authors to get all data needed
            String sql = "select * from application where depart = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, depart);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // For each record we need to create an Author Object AND a Book Object
                Application a = new Application();
                a.setId(rs.getInt("id"));
                a.setEid(rs.getString("eid"));
                a.setTodayDate(rs.getString("todaydate"));
                a.setLocation(rs.getString("location"));
                a.setDescription(rs.getString("description"));
                a.setCost(rs.getInt("cost"));
                a.setGrade(rs.getString("grade"));
                a.setEvent(rs.getString("typeevent"));
                a.setJustify(rs.getString("justification"));
                a.setReimbursement(rs.getDouble("reimbursement"));
                a.setDepart(rs.getInt("depart"));
                a.setAdmin1(rs.getBoolean("admin1"));
                a.setAdmin2(rs.getBoolean("admin2"));
                a.setAdmin3(rs.getBoolean("admin3"));


                app.add(a);
            }

            return app;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Application> getByApproval(){
        List<Application> app = new ArrayList<>();

        try (Connection conn = cu.getConnection()) {

            // we will need to use a join on books and authors to get all data needed
            String sql = "select * from application where admin1 = true and admin2 = true";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // For each record we need to create an Author Object AND a Book Object
                Application a = new Application();
                a.setId(rs.getInt("id"));
                a.setEid(rs.getString("eid"));
                a.setTodayDate(rs.getString("todaydate"));
                a.setLocation(rs.getString("location"));
                a.setDescription(rs.getString("description"));
                a.setCost(rs.getInt("cost"));
                a.setGrade(rs.getString("grade"));
                a.setEvent(rs.getString("typeevent"));
                a.setJustify(rs.getString("justification"));
                a.setReimbursement(rs.getDouble("reimbursement"));
                a.setDepart(rs.getInt("depart"));
                a.setAdmin1(rs.getBoolean("admin1"));
                a.setAdmin2(rs.getBoolean("admin2"));
                a.setAdmin3(rs.getBoolean("admin3"));


                app.add(a);
            }

            return app;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Application> getAll() {

        List<Application> app = new ArrayList<>();

        try (Connection conn = cu.getConnection()) {

            // we will need to use a join on books and authors to get all data needed
            String sql = "select * from application";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // For each record we need to create an Author Object AND a Book Object
                Application a = new Application();
                a.setEid(rs.getString("eid"));
                a.setTodayDate(rs.getString("todaydate"));
                a.setLocation(rs.getString("location"));
                a.setDescription(rs.getString("description"));
                a.setCost(rs.getInt("cost"));
                a.setGrade(rs.getString("grade"));
                a.setEvent(rs.getString("typeevent"));
                a.setJustify(rs.getString("justification"));
                a.setReimbursement(rs.getDouble("reimbursement"));
                a.setDepart(rs.getInt("depart"));
                a.setAdmin1(rs.getBoolean("admin1"));
                a.setAdmin2(rs.getBoolean("admin2"));
                a.setAdmin3(rs.getBoolean("admin3"));


                app.add(a);
            }

            return app;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateAppAdmin1(Integer id, String choice, Integer depart){

        try (Connection conn = cu.getConnection()) {

            String sql = "update application set admin1 = " + choice + " where id = ? and depart = ?";
            System.out.println(sql);
            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, choice);
            ps.setInt(1, id);
            ps.setInt(2, depart);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public void updateAppAdmin2(Integer id, String choice, Integer depart){

        try (Connection conn = cu.getConnection()) {

            String sql = "update application set admin2 = " + choice + " where id = ? and depart = ?";
            System.out.println(sql);
            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, choice);
            ps.setInt(1, id);
            ps.setInt(2, depart);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public void updateAppAdmin3(Integer id, String choice){

        try (Connection conn = cu.getConnection()) {

            String sql = "update application set admin3 = " + choice + " where id = ?";
            System.out.println(sql);
            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, choice);
            ps.setInt(1, id);


            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void updateReimbursement(Integer id, Integer reim){

        try (Connection conn = cu.getConnection()) {

            String sql = "update application set reimbursement = ? where id = ?";
            System.out.println(sql);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, reim);
            ps.setInt(2, id);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void approvePresent(Integer id, String approvepresent){

        try (Connection conn = cu.getConnection()) {

            String sql = "update application set approvepresent = ? where id = ?";
            System.out.println(sql);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, approvepresent);
            ps.setInt(2, id);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void adjustRe(Integer id, Integer reim){

        try (Connection conn = cu.getConnection()) {

            String sql = "update application set reimbursement = ? where id = ?";
            System.out.println(sql);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, reim);
            ps.setInt(2, id);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setStatus(Integer id, String status){

        try (Connection conn = cu.getConnection()) {

            String sql = "update application set status = ? where id = ?";
            System.out.println(sql);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2, id);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void appMessage(String eid, String reason){

        try (Connection conn = cu.getConnection()) {

            String sql = "insert into messages values (default, ?, ?)";
            System.out.println(sql);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, eid);
            ps.setString(2, reason);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBenefits(String eid, Integer reim){

        try (Connection conn = cu.getConnection()) {

            String sql = "update employees set totalbenefit = (select totalbenefit - ? as \"Subtraction\") where eid = ?";
            System.out.println(sql);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, reim);
            ps.setString(2, eid);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateZero(String eid, Integer zero){

        try (Connection conn = cu.getConnection()) {

            String sql = "update employees set totalbenefit = ? where eid = ?";
            System.out.println(sql);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, zero);
            ps.setString(2, eid);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Application application) {

    }

    @Override
    public void delete(Integer id) {

    }
}
