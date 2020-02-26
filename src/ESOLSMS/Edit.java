package ESOLSMS;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Edit {
    /*The Edit class is intended to make changes to the student
    * file and add students to Database*/

    public void addESOLStudent() {
        //addESOLStudent creates and writes student to file using userInput

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

            //Reset correct to false for input check
            boolean correct = false;
            System.out.println("Student's First Name:");
            while (!correct){
                firstName = sc.nextLine().trim();
                if (!firstName.equals("")){
                    correct = true;
                } else System.out.println("Please re-enter First Name:");
            }

            //Reset correct to false for input check
            correct = false;
            System.out.println("Student's Last Name:");
            while (!correct){
                lastName = sc.nextLine().trim();
                if (!lastName.equals("")){
                    correct = true;
                } else System.out.println("Please re-enter Last Name:");
            }

            birthDate = null;
            correct = false;
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

            //Reset correct to false for input check
            correct = false;
            System.out.println("Student's Grade Level");
            while (!correct){
                gradeLevel = sc.nextLine().trim();
                if (!gradeLevel.equals("")){
                    correct = true;
                } else System.out.println("Please re-enter Grade Level:");
            }

            //Reset correct to false for input check
            correct = false;
            System.out.println("Student's ID Number");
            while (!correct) {
                String userInput = sc.nextLine();
                try {
                    studentId = Integer.parseInt(userInput);
                    correct = true;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter student Id with numbers only");
                }
            }

            //Reset correct to false for input check
            correct = false;
            System.out.println("Student's English Level:");
            while (!correct){
                englishLevel = sc.nextLine().trim();
                if (!englishLevel.equals("")){
                    correct = true;
                } else System.out.println("Please re-enter English Level:");
            }

            //Reset correct to false for input check
            correct = false;
            System.out.println("Student's First Spoken Language:");
            while (!correct){
                firstLanguage = sc.nextLine().trim();
                if (!firstLanguage.equals("")){
                    correct = true;
                } else System.out.println("Please re-enter First Spoken Language:");
            }
        }
        catch (InputMismatchException e) {
            e.printStackTrace();
        }

        //Add student to database
        SqlUpdates.addESOLStudentToDB(firstName, lastName, birthDate, gradeLevel, studentId, englishLevel,firstLanguage);
    }
}
