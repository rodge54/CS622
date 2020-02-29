package ESOLSMS;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SqlSearch {
    /*Provide sql search methods for searching multiple databases*/

    public static final ArrayList<Student> newStudArr = new ArrayList<>();
    public static final ArrayList<Teacher> newTeachArr = new ArrayList<>();
    //Languages array is not yet implemented and will
    // be an empty array as placeholder
    public static final ArrayList<String> languagesSpoken = new ArrayList<>();

    public static final String url =
            "jdbc:sqlite:D:\\BostonUniversity\\GitHub_CS622_ESOLSMS\\ESOLSMSDB.db";

    public static final String TABLE_STUDENTS = "Students";
    public static final String COLUMN_STUDENT_S_ID = "S_ID";
    public static final String COLUMN_STUDENT_FIRST_NAME = "firstName";
    public static final String COLUMN_STUDENT_LAST_NAME = "lastName";
    public static final String COLUMN_STUDENT_BIRTHDATE = "birthDate";
    public static final String COLUMN_STUDENT_GRADE_LEVEL = "gradeLevel";

    public static final String TABLE_ESOL_STUDENTS = "ESOLstudents";
    public static final String COLUMN_ESOLSTUDENT_STUDENT_ID = "studentId";
    public static final String COLUMN_ESOLSTUDENT_ENGLISH_LEVEL = "englishLevel";
    public static final String COLUMN_ESOLSTUDENT_FIRST_LANGUAGE = "firstLanguage";

    public static final String TABLE_TEACHERS = "teachers";
    public static final String COLUMN_TEACHER_FIRST_NAME = "'firstName'";
    public static final String COLUMN_TEACHER_LAST_NAME = "lastName";
    public static final String COLUMN_TEACHER_EMAILADDRESS = "emailAddress";
    public static final String COLUMN_TEACHER_TITLE = "title";
    public static final String COLUMN_TEACHER_GRADE_LEVEL = "gradeLevel";

    public ArrayList<?> queryByLastName(String name, int indicator){
        /*This method searches for students or teachers by last name based
        on users choice at the main menu*/

        //Clear arrays for GUI to process next search
        newStudArr.clear();
        newTeachArr.clear();

        //Checks if user is searching for an ESOLStudent or ESOLTeacher
        try (Connection conn = DriverManager.getConnection(url);
             Statement statement = conn.createStatement()){//OPEN/CLOSE resources

            //When searching for ESOLstudent, SORTED by last name
            if (indicator == 1) {
                ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_STUDENTS +
                        " INNER JOIN " + TABLE_ESOL_STUDENTS + " ON " + COLUMN_STUDENT_S_ID + " = " + COLUMN_ESOLSTUDENT_STUDENT_ID +
                        " WHERE " + COLUMN_STUDENT_LAST_NAME + " = " + "'" + name +"'" +
                        " ORDER BY " + COLUMN_STUDENT_LAST_NAME + " asc");

                while (results.next()){
                    Student student = new ESOLStudent(
                            results.getString(COLUMN_STUDENT_FIRST_NAME),
                            results.getString(COLUMN_STUDENT_LAST_NAME),
                            results.getString(COLUMN_STUDENT_BIRTHDATE),
                            results.getString(COLUMN_STUDENT_GRADE_LEVEL),
                            results.getInt(COLUMN_ESOLSTUDENT_STUDENT_ID),
                            results.getString(COLUMN_ESOLSTUDENT_ENGLISH_LEVEL),
                            results.getString(COLUMN_ESOLSTUDENT_FIRST_LANGUAGE));
                    newStudArr.add(student);
                }

                if (newStudArr.isEmpty()){
                    System.out.println("Student not found");
                }
                return newStudArr;

            //When searching for ESOLTeacher, SORTED by last name
            } else if (indicator == 2) {
                ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_TEACHERS +
                            " WHERE " + COLUMN_TEACHER_LAST_NAME + " = " + "'" + name +"'" +
                        " ORDER BY " + COLUMN_TEACHER_LAST_NAME + " asc");

                while (results.next()){
                    Teacher teacher = new ESOLTeacher(
                            results.getString(COLUMN_TEACHER_FIRST_NAME),
                            results.getString(COLUMN_TEACHER_LAST_NAME),
                            results.getString(COLUMN_TEACHER_EMAILADDRESS),
                            results.getString(COLUMN_TEACHER_TITLE),
                            results.getString(COLUMN_TEACHER_GRADE_LEVEL),
                            languagesSpoken);
                    newTeachArr.add(teacher);
                }

                if (newTeachArr.isEmpty()){
                    System.out.println("Teacher not found");
                }
                return newTeachArr;
            }
        }
        catch (SQLException e){
            System.out.println("Something went wrong " + e.getMessage() + Arrays.toString(e.getStackTrace()));
        }
        return null;
    }

    public ArrayList<?> queryByEnglishLevel(String level, int indicator){
        /*This method searches for students or teachers by English Speaking Level
         based on users choice at the main menu*/

        //Clear arrays for GUI to process next search
        newStudArr.clear();
        newTeachArr.clear();

        //Checks if user is searching for an ESOLStudent or ESOLTeacher
        try (Connection conn = DriverManager.getConnection(url);
             Statement statement = conn.createStatement()){//OPEN/CLOSE resources

            //When searching for ESOLstudent, SORTED by last name
            if (indicator == 1) {
                ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_STUDENTS +
                        " INNER JOIN " + TABLE_ESOL_STUDENTS + " ON " + COLUMN_STUDENT_S_ID + " = " + COLUMN_ESOLSTUDENT_STUDENT_ID +
                        " WHERE " + COLUMN_ESOLSTUDENT_ENGLISH_LEVEL + " = " + "'" + level +"'" +
                        " ORDER BY " + COLUMN_STUDENT_LAST_NAME + " asc");

                while (results.next()){
                    Student student = new ESOLStudent(
                            results.getString(COLUMN_STUDENT_FIRST_NAME),
                            results.getString(COLUMN_STUDENT_LAST_NAME),
                            results.getString(COLUMN_STUDENT_BIRTHDATE),
                            results.getString(COLUMN_STUDENT_GRADE_LEVEL),
                            results.getInt(COLUMN_ESOLSTUDENT_STUDENT_ID),
                            results.getString(COLUMN_ESOLSTUDENT_ENGLISH_LEVEL),
                            results.getString(COLUMN_ESOLSTUDENT_FIRST_LANGUAGE));
                    newStudArr.add(student);
                }

                if (newStudArr.isEmpty()){
                    System.out.println("Student not found");
                }
                return newStudArr;
            }
        }
        catch (SQLException e){
            System.out.println("Something went wrong " + e.getMessage() + Arrays.toString(e.getStackTrace()));
        }
        return null;
    }

    public ArrayList<?> queryByGradeLevel(String grade, int indicator){
        /*This method searches for students or teachers by Grade Level
         based on users choice at the main menu*/

        //Clear arrays for GUI to process next search
        newStudArr.clear();
        newTeachArr.clear();

        //Checks if user is searching for an ESOLStudent or ESOLTeacher
        try (Connection conn = DriverManager.getConnection(url);
             Statement statement = conn.createStatement()){//OPEN/CLOSE resources

            //When searching for ESOLstudent, SORTED by last name
            if (indicator == 1) {
                ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_STUDENTS +
                        " INNER JOIN " + TABLE_ESOL_STUDENTS + " ON " + COLUMN_STUDENT_S_ID + " = " + COLUMN_ESOLSTUDENT_STUDENT_ID +
                        " WHERE " + COLUMN_STUDENT_GRADE_LEVEL + " = " + "'" + grade +"'" +
                        " ORDER BY " + COLUMN_STUDENT_LAST_NAME + " asc");

                while (results.next()){
                    Student student = new ESOLStudent(
                            results.getString(COLUMN_STUDENT_FIRST_NAME),
                            results.getString(COLUMN_STUDENT_LAST_NAME),
                            results.getString(COLUMN_STUDENT_BIRTHDATE),
                            results.getString(COLUMN_STUDENT_GRADE_LEVEL),
                            results.getInt(COLUMN_ESOLSTUDENT_STUDENT_ID),
                            results.getString(COLUMN_ESOLSTUDENT_ENGLISH_LEVEL),
                            results.getString(COLUMN_ESOLSTUDENT_FIRST_LANGUAGE));
                    newStudArr.add(student);
                }

                if (newStudArr.isEmpty()){
                    System.out.println("Student not found");
                }
                return newStudArr;

                //When searching for ESOLTeacher, SORTED by last name
            } else if (indicator == 2) {
                ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_TEACHERS +
                        " WHERE " + COLUMN_TEACHER_GRADE_LEVEL + " = " + "'" + grade +"'"+
                        " ORDER BY " + COLUMN_TEACHER_LAST_NAME + " asc");

                while (results.next()){
                    Teacher teacher = new ESOLTeacher(
                            results.getString(COLUMN_TEACHER_FIRST_NAME),
                            results.getString(COLUMN_TEACHER_LAST_NAME),
                            results.getString(COLUMN_TEACHER_EMAILADDRESS),
                            results.getString(COLUMN_TEACHER_TITLE),
                            results.getString(COLUMN_TEACHER_GRADE_LEVEL),
                            languagesSpoken);
                    newTeachArr.add(teacher);
                }

                if (newTeachArr.isEmpty()){
                    System.out.println("Teacher not found");
                }
                return newTeachArr;
            }
        }
        catch (SQLException e){
            System.out.println("Something went wrong " + e.getMessage() + Arrays.toString(e.getStackTrace()));
        }
        return null;
    }

}
