package com.dev.utilis;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

    private static ConnectionUtil cu = null;
    private static Properties props;

    private ConnectionUtil(){
        props = new Properties();

        InputStream dbProps = ConnectionUtil.class.getClassLoader().getResourceAsStream("connection.properties");
        try {
            props.load(dbProps);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ConnectionUtil getConnectionUtil(){

        if (cu == null){
            cu = new ConnectionUtil();
        }
        return cu;
    }

    public Connection getConnection(){

        Connection conn = null;

        // Hot fix to basically force the Driver class to load
        try {
            Class.forName(props.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Get the credentials needed to access the database from our connection.properties file
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;

    }

    public static void main(String[] args){

        Connection connection = getConnectionUtil().getConnection();

        if (connection != null){
            System.out.println("Connection Successful");
        } else {
            System.out.println("Connection Error!");
        }

    }

}