package ESOLSMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class sqlUpdates {
    /*Builds tables and adds students/teacher to a database*/

    public static final String url =
            "jdbc:sqlite:D:\\BostonUniversity\\GitHub_CS622_ESOLSMS\\ESOLSMSDB.db";

    public static void createESOLStudentTables(){
        /*Builds table for ESOL Students*/

        try (Connection conn = DriverManager.getConnection(url);
             Statement statement = conn.createStatement()){//OPEN/CLOSE resources

            statement.execute("CREATE TABLE IF NOT EXISTS ESOLstudents" +
                    " (firstName TEXT, lastName TEXT, birthDate TEXT, " +
                    "gradeLevel TEXT, studentId TEXT, englishLevel TEXT, " +
                    "firstLanguage TEXT)");
        }
        catch (SQLException e){
            System.out.println("Something went wrong " + e.getMessage());
        }
    }

    public static void createTeacherTables(){
        /*Builds table for teachers*/

        try (Connection conn = DriverManager.getConnection(url);
             Statement statement = conn.createStatement()){//OPEN/CLOSE resources

            statement.execute("CREATE TABLE IF NOT EXISTS teachers" +
                    " (firstName TEXT, lastName TEXT, emailAddress TEXT, title TEXT, gradeLevel TEXT)");
        }
        catch (SQLException e){
            System.out.println("Something went wrong " + e.getMessage());
        }
    }

    public static void addESOLStudent(String firstName, String lastName, String birthDate, String gradeLevel,
                           int studentId, String englishLevel, String firstLanguage){
        /*Adds Student to Database using user input from edit.java class*/

        try (Connection conn = DriverManager.getConnection(url);
             Statement statement = conn.createStatement()){//OPEN/CLOSE resources

            statement.execute("INSERT INTO ESOLstudents (firstName, lastName, birthDate, " +
                    "gradeLevel, studentId, englishLevel, firstLanguage)" +
                    "VALUES('" + firstName +"' , '" + lastName +"' , '" + birthDate +"','"
                    + gradeLevel +"', '" + studentId +"', '" + englishLevel +"','" + firstLanguage +"')");
        }
        catch (SQLException e){
            System.out.println("Something went wrong " + e.getMessage());
        }
    }
}



