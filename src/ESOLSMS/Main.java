package ESOLSMS;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        //Build Arrays for students and languages spoken.
        ArrayList<String> langArr = new ArrayList<>();
        ArrayList<String> langArr1 = new ArrayList<>();
        ArrayList<Student> studArr = new ArrayList<>();

        langArr.add("English");
        langArr.add("Italian");
        ArrayList<Teacher> teachersArr = new ArrayList<>();

        //Build teachers and paraprofessionals as examples
        Teacher esolTeach = new ESOLTeacher("Marika","Ruzzon",
                "marika@email.com","Ms.", "12", langArr);
        Teacher esolPara = new ESOLParaprofessional("Donald","Trump",
                "realDonaldTrump@twitter.com", "President", "11",
                langArr1, false, false);
        teachersArr.add(esolTeach);
        teachersArr.add(esolPara);

//       *****************************************MAIN PROGRAM START************************************************
        //Print Welcome Message
        Menus.welcomeMessage();

        //Check if file exists
        File studentFile = new File("studentInfo.txt");
        boolean exists = studentFile.exists();

        //Create scanner if file exists, else exit program
        Scanner sc = null;
        if (exists){
            sc = new Scanner(studentFile);
        }
        else {
            System.out.println(studentFile + " NOT FOUND, Please contact Program Admin");
            System.out.println();
            System.exit(0);
        }

        //Initialize student variables
        String firstName = null;
        String lastName = null;
        String birthDate = null;
        String gradeLevel = null;
        int studentId = 0;
        String englishLevel = null;
        String firstLanguage = null;

        //Build STUDENT ArrayList from studentFile
        while (sc.hasNext()){
            firstName = sc.next();
            lastName = sc.next();
            birthDate = sc.next();
            gradeLevel = sc.next();
            studentId = sc.nextInt();
            englishLevel = sc.next();
            firstLanguage = sc.next();
            //Don't read in teacherArr
            sc.next();
            studArr.add(new ESOLStudent(firstName, lastName, birthDate,
                    gradeLevel, studentId, englishLevel, firstLanguage, teachersArr));
        }
        sc.close();

        //Create ESOLStudentSearch Object class using ESOLStudent -
        ESOLStudentTeacherSearch studSearch = new ESOLStudentTeacherSearch();
        int i;
        boolean correct = false;

        while(!correct){

            Menus.startMenu();

            sc = new Scanner(System.in);
            int userInput1 = 0;

            //Checks that selection from numbered list is correct
            try{
                userInput1 = sc.nextInt();
            }

            catch (InputMismatchException e){
                System.out.println("Not in list, please enter new number");
                TimeUnit.SECONDS.sleep(2);
            }

            sc = new Scanner(System.in);
            String userInput2;

            //Each Menu Item is represented through switch cases
            switch (userInput1){

                case 1:
                    System.out.println("Please enter the Last Name of Students you would like to find: ");
                    userInput2 = sc.nextLine();
                    ArrayList<Integer> indexArr = studSearch.searchByLastName(userInput2, studArr);

                    //If student not found message
                    if (indexArr.isEmpty()){
                        System.out.println("No students found with Last Name " + userInput2);
                        TimeUnit.SECONDS.sleep(2);
                        break;
                    }

                    //If student found, print all students and return true
                    correct = GenericClass.printPerson(studArr, indexArr);
                    break;

                case 2:
                    System.out.println("Please enter the English Level of Student's you would like to find: ");
                    userInput2 = sc.nextLine();
                    indexArr = studSearch.searchByEnglishLevel(userInput2, studArr);

                    //If student not found message
                    if (indexArr.isEmpty()){
                        System.out.println("No students found at English Level " + userInput2);
                        TimeUnit.SECONDS.sleep(2);
                        break;
                    }

                    //If student found, print all students and return true
                    correct = GenericClass.printPerson(studArr, indexArr);
                    break;

                case 3:
                    System.out.println("Please enter the Grade Level of Student's you would like to find: ");
                    userInput2 = sc.nextLine();
                    indexArr = studSearch.searchByGradeLevel(userInput2, studArr);

                    //If student not found message
                    if (indexArr.isEmpty()){
                        System.out.println("No students found at Grade Level " + userInput2);
                        TimeUnit.SECONDS.sleep(2);
                        break;
                    }

                    //If student found, print all students and return true
                    correct = GenericClass.printPerson(studArr, indexArr);
                    break;

                case 4:
                    Edit edit = new Edit();
                    edit.addESOLStudent();
                    correct = true;
                    break;

                case 5:
                    System.out.println("Please enter the Grade Level of Teachers you would like to find: ");
                    userInput2 = sc.nextLine();
                    indexArr = studSearch.searchByGradeLevel(userInput2, teachersArr);

                    //If student not found message
                    if (indexArr.isEmpty()){
                        System.out.println("No teachers found at Grade Level " + userInput2);
                        TimeUnit.SECONDS.sleep(2);
                        break;
                    }

                    //If student found, print all teachers and return true
                    correct = GenericClass.printPerson(teachersArr, indexArr);
                    break;

                case 6:
                    System.out.println("Please enter the Last Name of Teachers you would like to find: ");
                    userInput2 = sc.nextLine();
                    indexArr = studSearch.searchByLastName(userInput2, teachersArr);

                    //If student not found message
                    if (indexArr.isEmpty()){
                        System.out.println("No teachers found with Last Name " + userInput2);
                        TimeUnit.SECONDS.sleep(2);
                        break;
                    }

                    //If student found, print all teachers and return true
                    correct = GenericClass.printPerson(teachersArr, indexArr);
                    break;

                default:

                    System.out.println("Not in list, please enter new number");
                    TimeUnit.SECONDS.sleep(2);
            }
        }
        sc.close();
    }
}
