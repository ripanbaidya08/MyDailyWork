package com.mydailywork.ripan.task.task5.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.mydailywork.ripan.task.task5.main.StudentCourseRegistrationSystem.DISPLAY_COURSE_DETAILS;

public class StudentCourseDatabaseUtil {

    private StudentCourseDatabaseUtil(){ }

    private static Scanner scan = null ;
    private static Connection connection = null ;
    private static ResultSet resultSet = null ;
    private static PreparedStatement preparedStatement = null ;

    static {
        try { // establishing connection..
            if (connection == null)
                connection = DatabaseUtil.getDatabaseConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // this method is used to get all available course information
    public static ResultSet getAvailableCourseInformation(){
        try {
            if (connection != null && DISPLAY_COURSE_DETAILS != null)
                    preparedStatement = connection.prepareStatement(DISPLAY_COURSE_DETAILS);
            if (preparedStatement != null && resultSet == null)
                resultSet =  preparedStatement.executeQuery();
            return resultSet;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    // this method is used to register course
    public static void registerCourse(int cid, String c_code, int sid) {
        try {
            if (connection == null)
                connection = DatabaseUtil.getDatabaseConnection();

            String sql = "INSERT INTO registration (cid, c_code, sid) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, cid);
            preparedStatement.setString(2, c_code);
            preparedStatement.setInt(3, sid);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new course registration was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    // this method is used to drop course
    public static void dropCourse(int id) {
        String dropQuery = "delete from registration where sid = ?";
        int rowUpdate = 0;

        try {
            if(connection != null && preparedStatement == null)
                preparedStatement = connection.prepareStatement(dropQuery);
            if(preparedStatement != null){
                preparedStatement.setInt(1, id);
                rowUpdate = preparedStatement.executeUpdate();
            }
            if(rowUpdate == 0)
                System.out.println("Course Drop Failed");
            else
                System.out.println("Course Drop Successfully");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
