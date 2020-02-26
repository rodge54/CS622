package ESOLSMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlUpdates {
    /*Builds tables and adds students/teachers to a database*/

    public static final String url =
            "jdbc:sqlite:D:\\BostonUniversity\\GitHub_CS622_ESOLSMS\\ESOLSMSDB.db";

    public static void createStudentTables(){
        /*Builds table for Students*/

        try (Connection conn = DriverManager.getConnection(url);
             Statement statement = conn.createStatement()){//OPEN/CLOSE resources

            statement.execute("CREATE TABLE IF NOT EXISTS Students" +
                    " (S_ID INTEGER NOT NULL, firstName TEXT, lastName TEXT, birthDate TEXT, " +
                    "gradeLevel TEXT, PRIMARY KEY (S_ID))");
        }
        catch (SQLException e){
            System.out.println("Something went wrong " + e.getMessage());
        }
    }

    public static void createESOLStudentTables(){
        /*Builds table for ESOL Students that references Students table*/

        try (Connection conn = DriverManager.getConnection(url);
             Statement statement = conn.createStatement()){//OPEN/CLOSE resources

            statement.execute("CREATE TABLE IF NOT EXISTS ESOLstudents" +
                    " (studentId INTEGER, englishLevel TEXT, " +
                    "firstLanguage TEXT, FOREIGN KEY(studentId) REFERENCES Students(S_ID))");
        }
        catch (SQLException e){
            System.out.println("ESOLStudent Error " + e.getMessage());
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

    public static void addESOLStudentToDB(String firstName, String lastName, String birthDate, String gradeLevel,
                           int studentId, String englishLevel, String firstLanguage){
        /*Adds Student to Database using user input from edit.java class*/

        try (Connection conn = DriverManager.getConnection(url);
             Statement statement = conn.createStatement()){//OPEN/CLOSE resources

            statement.execute("INSERT INTO Students (S_ID, firstName, lastName, birthDate,gradeLevel)" +
                    "VALUES('" + studentId +"','" + firstName +"','" + lastName +"','" + birthDate +"','"+ gradeLevel +"')");

            statement.execute("INSERT INTO ESOLstudents (studentId, englishLevel, firstLanguage)" +
                    "VALUES('" + studentId +"','" + englishLevel +"','" + firstLanguage +"')");
            
        }
        catch (SQLException e){
            System.out.println("Something went wrong " + e.getMessage());
        }
    }
}



