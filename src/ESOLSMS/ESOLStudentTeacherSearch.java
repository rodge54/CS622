package ESOLSMS;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ESOLStudentTeacherSearch{

    public String searchTeacherOfStudent( String studentFirstName, String studentLastName, ArrayList<Teacher> teachersArr){
        /*Searches for teachers for specific student
        * AWAITING IMPLEMENTATION*/

        String teacher = "Ms. Marika";
        System.out.println("Find ESOL STUDENT's teacher in progress...");
        System.out.println("Awaiting Implementation");
        return teacher;
    }

    public ArrayList<Student> buildStudentArray() throws FileNotFoundException {
        //Builds student array for search function

        ArrayList<Student> studArr = new ArrayList<>();
        ArrayList<Teacher> teachersArr = new ArrayList<>();

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
        //Write to Binary file
        FileBinaryOutput.ESOLStudentToBinaryFile(studArr);
        return studArr;
    }

    public ArrayList<Student> searchByEnglishLevelWithStream(String englishLevel, ArrayList<Student> studArr){

        /*This class searches for students by English Speaking Level based
        on users choice at the main menu*/

        //Try-Catch checks if user is searching for an ESOLStudent
        //Used for future implementation of additional student types
        ArrayList<Student> newStudArr = new ArrayList<>();

        try {
            studArr.stream().filter(p -> ((ESOLStudent)p).getEnglishLevel().equals(englishLevel)).forEach(p -> newStudArr.add(p));
            if (newStudArr.isEmpty()){
                System.out.println("Student at English Level " + englishLevel + " not found");
            }
            return newStudArr;
        }
        catch (ClassCastException ignored){}
        return null;
    }

    public ArrayList<?> searchByGradeLevelWithStream(String gradeLevel, ArrayList<?> personArr){

        /*This class searches for students or teachers by last name based
        on users choice at the main menu*/

        ArrayList<Student> newStudArr = new ArrayList<>();
        ArrayList<Teacher> newTeachArr = new ArrayList<>();

        //Try-Catch checks if user is searching for an ESOLStudent
        try{
            personArr.stream().filter(p -> ((ESOLStudent)p).getGradeLevel().equals(gradeLevel))
                    .forEach(p -> newStudArr.add((ESOLStudent)p));
            if (newStudArr.isEmpty()){
                System.out.println("Student in Grade Level " + gradeLevel + " not found");
            }
            return newStudArr;//Return students ArrayList
        }
        catch (ClassCastException ignored){}

        //Try-Catch checks if user is searching for ESOLTeacher
        try {
            personArr.stream().filter(p -> ((Teacher)p).getGradeLevel().equals(gradeLevel))
                    .forEach(p -> newTeachArr.add((Teacher)p));
            if (newTeachArr.isEmpty()){
                System.out.println("Teacher in Grade Level " + gradeLevel + " not found");
            }
            return newTeachArr;//Return teachers ArrayList
        }
        catch (ClassCastException ignored){}
        return null;
    }

    public ArrayList<?> searchByLastNameWithStream(String name, ArrayList<?> personArr){

        /*This class searches for students or teachers by last name based
        on users choice at the main menu*/

        ArrayList<Student> newStudArr = new ArrayList<>();
        ArrayList<Teacher> newTeachArr = new ArrayList<>();

        //Try-Catch checks if user is searching for an ESOLStudent
        try{
            personArr.stream().filter(p -> ((ESOLStudent)p).getLastName().equals(name)).forEach(p -> newStudArr.add((ESOLStudent)p));
            if (newStudArr.isEmpty()){
                System.out.println("Student with Last Name " + name + " not found");
            }
            return newStudArr;//Return students ArrayList
        }
        catch (ClassCastException ignored){}

        //Try-Catch checks if user is searching for ESOLTeacher
        try {
            personArr.stream().filter(p -> ((Teacher)p).getLastName().equals(name)).forEach(p -> newTeachArr.add((Teacher)p));
            if (newTeachArr.isEmpty()){
                System.out.println("Teacher with Last Name " + name + " not found");
            }
            return newTeachArr;//Return teachers ArrayList
        }
        catch (ClassCastException ignored){}
        return null;
    }
}
