package ESOLSMS;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Edit {
    /*The Edit class is intended to make changes to the student
    * file and add students to Database*/

    public void addESOLStudent() {
        //addESOLStudent creates and writes student to file using userInput

        ArrayList<Teacher> teachersArr = new ArrayList<>();
        //Initialize variables
        String firstName = null;
        String lastName = null;
        String birthDate = null;
        String gradeLevel = null;
        int studentId = 0;
        String englishLevel = null;
        String firstLanguage = null;

        //Accept userInput and update variables
        try (Scanner sc = new Scanner(System.in)){//Open/Close Scanner

            System.out.println("Student's First Name:");
            firstName = sc.nextLine();

            System.out.println("Student's Last Name:");
            lastName = sc.nextLine();

            birthDate = null;
            boolean correct = false;
            System.out.println("Student's Birthdate (yyyy/mm/dd):");

            //While loop checks for Birthdate validity
            while (!correct) {
                birthDate = sc.nextLine();
                if (birthDate.matches("\\d{4}/\\d{2}/\\d{2}")) {
                    correct = true;
                } else {
                    System.out.println("Please enter Birthdate in yyyy/mm/dd format");
                }
            }

            System.out.println("Student's Grade Level");
            gradeLevel = sc.nextLine();

            System.out.println("Student's ID Number");
            correct = false;

            while (!correct) {
                String userInput = sc.nextLine();
                try {
                    studentId = Integer.parseInt(userInput);
                    correct = true;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter student Id with numbers only");
                }
            }

            System.out.println("Student's English Level:");
            englishLevel = sc.nextLine();

            System.out.println("Student's First Spoken Language:");
            firstLanguage = sc.nextLine();
        }
        catch (InputMismatchException e) {
            e.printStackTrace();
        }

        //Add student to database
        sqlUpdates.addESOLStudent(firstName, lastName, birthDate, gradeLevel, studentId, englishLevel,firstLanguage);

        //Create Student from user input using empty teachers array
        Student student = new ESOLStudent(firstName,lastName, birthDate, gradeLevel, studentId, englishLevel,firstLanguage, teachersArr);

        File studentFile = new File("studentInfo.txt");

        //Append student to file
        try (FileWriter fileWriter = new FileWriter(studentFile, true))
            /*Open/Close fileWriter*/{
            fileWriter.append("\n" +
                    student.getFirstName() + " " +
                    student.getLastName() + " " +
                    student.getBirthDate() + " " +
                    student.getGradeLevel() + " " +
                    ((ESOLStudent) student).getStudentId() + " " +
                    ((ESOLStudent) student).getEnglishLevel() + " " +
                    ((ESOLStudent) student).getFirstLanguage() + " " +
                    ((ESOLStudent) student).getTeachers());
            System.out.println("Student added Successfully");
        }
        //If file not found
        catch (IOException | NullPointerException e){
            System.out.println("File " + studentFile + " Not Found, Please contact Program Admin");
        }
    }
}
