package com.dev.repositories;

import com.dev.models.Application;
import com.dev.models.Message;
import com.dev.models.Messenger;
import com.dev.utilis.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageJDBC implements CrudRepo<Message>{

    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    @Override
    public Message add(Message message) {
        return null;
    }


    @Override
    public Message getById(Integer id) {
        return null;
    }

    public List<Message> getAllByEid(String eid){

        List<Message> mess = new ArrayList<>();

        try (Connection conn = cu.getConnection()) {

            // we will need to use a join on books and authors to get all data needed
            String sql = "select * from messages where eid = ?";
            System.out.println(sql);

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, eid);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // For each record we need to create an Author Object AND a Book Object
                Message m = new Message();
                m.setId(rs.getInt("id"));
                m.setEid(rs.getString("eid"));
                m.setMessage(rs.getString("message"));

                mess.add(m);
            }

            return mess;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public List<Messenger> getAllAdminMessage(){

        List<Messenger> mess = new ArrayList<>();

        try (Connection conn = cu.getConnection()){

            String sql = "select * from messager";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Messenger m = new Messenger(
                        rs.getInt("id"),
                        rs.getString("lastname"),
                        rs.getString("message")
                );
                mess.add(m);
            }

            return mess;

        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public List<Message> getAll() {

        return null;
    }

    @Override
    public void update(Message message) {

    }

    public void addAdminMessage(String lastname, String message){
        try (Connection conn = cu.getConnection()) {

            String sql = "insert into messager values (default, ?, ?)";
            System.out.println(sql);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, lastname);
            ps.setString(2, message);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {

    }
}
