package com.mydailywork.ripan.task.task5.utility;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class DatabaseUtil {

    private DatabaseUtil(){ }

    static Properties properties = null ;

    static {
        FileInputStream fileInputStream = null ;
        String fileInfo = "C:\\internship\\MyDailyWork\\src\\com\\mydailywork\\ripan\\main\\task5\\properties\\mySqldb.properties";
        try {
            if(fileInputStream == null)
                fileInputStream = new FileInputStream(fileInfo);
                properties = new Properties();
                properties.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getDatabaseConnection() throws SQLException {
        return DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("password"));
    }

    public static void cleanUpResourses(Connection connection, ResultSet resultSet, Statement statement){
        try{
            // close connection
            if(connection != null)
                connection.close();

            // closing the resultset
            if (resultSet != null)
                resultSet.close();

            // closing the statement
            if (statement != null)
                statement.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
