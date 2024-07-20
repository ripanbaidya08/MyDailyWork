package com.mydailywork.ripan.task.task5.main;

import com.mydailywork.ripan.task.task5.utility.DatabaseUtil;
import com.mydailywork.ripan.task.task5.utility.StudentCourseDatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner ;

public class StudentCourseRegistrationSystem {

    public static final String DISPLAY_COURSE_DETAILS = "select cid, ccode, cdescription, capacity from courses";

    public static void main(String[] args) {

        Connection connection = null ;
        PreparedStatement preparedStatement = null ;
        ResultSet resultSet = null ;
        Scanner scanner = new Scanner(System.in);

        try{
            resultSet = StudentCourseDatabaseUtil.getAvailableCourseInformation();

            if (resultSet != null) {
                System.out.println("List of Available Courses along with the Information : ");
                System.out.println("Course Code\tCourse Description\tCapacity");
                while (resultSet.next()) {
                    System.out.println(String.format("%d\t%-15s%-30s%10s",resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                            resultSet.getString(4)));
                }
            }

            System.out.println("Hey Student,You want to register for a course?(yes/no) : ");
            String choice = scanner.next();

            if(choice.equalsIgnoreCase("yes")){
                System.out.println("Enter Student id : ");
                int sid = scanner.nextInt();
                System.out.println("Enter the Course Id : ");
                int cid = scanner.nextInt();
                System.out.println("Enter the course code : ");
                String c_code = scanner.next();

                StudentCourseDatabaseUtil.registerCourse(cid, c_code, sid); // cid, c_code, sid

                System.out.println("Do You want to drop course?(yes/no) : ");
                choice = scanner.next();

                if(choice.equalsIgnoreCase("yes")){
                    System.out.println("Enter your id : ");
                    sid = scanner.nextInt();
                    StudentCourseDatabaseUtil.dropCourse(sid);
                } else{
                    System.out.println("Thank you for using our application.");
                    System.exit(0);
                }
            } else {
                System.out.println("Thank you for using our application.");
                System.exit(0);
            }
        }catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DatabaseUtil.cleanUpResourses(connection, resultSet, preparedStatement);
        }
    }
}
