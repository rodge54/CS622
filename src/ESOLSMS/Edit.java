package ESOLSMS;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Edit {

    public void addESOLStudent(ArrayList<Student> studArr) throws IOException{

        //Asks for UserInput then appends Object to txt file
        ArrayList<Teacher> teachersArr = new ArrayList<>();

        //Check if file exists and initialize FileWriter
        File studentFile = new File("studentInfo.txt");
        boolean exists = studentFile.exists();
        FileWriter fileWriter = null;

        //Append to file if file exist, else exit program
        if (exists){
             fileWriter = new FileWriter(studentFile, true);
        }
        else {
            System.out.println("File Not Found, Please contact Program Admin");
            System.exit(0);
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("Student's First Name:");
        String firstName = sc.nextLine();

        System.out.println("Student's Last Name:");
        String lastName = sc.nextLine();

        String birthDate = null;
        boolean correct = false;
        System.out.println("Student's Birthdate (yyyy/mm/dd):");

        //While loop checks for Birthdate validity
        while (!correct) {
            birthDate = sc.nextLine();
            if (birthDate.matches("\\d{4}/\\d{2}/\\d{2}")){
                correct = true;
            }

            else{
                System.out.println("Please enter Birthdate in yyyy/mm/dd format");
            }
        }

        System.out.println("Student's Grade Level");
        String gradeLevel = sc.nextLine();

        System.out.println("Student's ID Number");
        correct = false;
        String studentId = null;

        while (!correct){
            String userInput = null;

            try{
                userInput = sc.nextLine();
                studentId = userInput;
                correct = true;
            }
            catch (InputMismatchException e){
                System.out.println("Please enter student Id with numbers only");
            }
        }

        System.out.println("Student's English Level:");
        String englishLevel = sc.nextLine();
        
        System.out.println("Student's First Spoken Language:");
        String firstLanguage = sc.nextLine();
        sc.close();

        //Create Student from user input using empty teachers array
        Student student = new ESOLStudent(firstName,lastName, birthDate, gradeLevel, studentId, englishLevel,firstLanguage, teachersArr);
        System.out.println("Student added Successfully");

        //Write to studentInfo.txt file
        fileWriter.append("\n" +
                student.getFirstName() + " " +
                student.getLastName() + " " +
                student.getBirthDate() + " " +
                student.getGradeLevel() + " " +
                ((ESOLStudent)student).getStudentId() + " " +
                ((ESOLStudent)student).getEnglishLevel() + " " +
                ((ESOLStudent)student).getFirstLanguage() + " " +
                ((ESOLStudent)student).getTeachers());
        fileWriter.close();
    }
}
