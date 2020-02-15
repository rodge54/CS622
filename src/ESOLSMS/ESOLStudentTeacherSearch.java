package ESOLSMS;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class ESOLStudentTeacherSearch{

    public String searchTeacherOfStudent( String studentFirstName, String studentLastName, ArrayList<Teacher> teachersArr){

        String teacher = "Ms. Marika";
        System.out.println("Find ESOL STUDENT's teacher in progress...");
        System.out.println("Awaiting Implementation");
        return teacher;
    }

    public ArrayList<Student> searchByEnglishLevelWithStream(String englishLevel, ArrayList<Student> studArr){
        ArrayList<Student> newStudArr = new ArrayList<>();
        studArr.stream().filter(p -> ((ESOLStudent)p).getEnglishLevel().equals(englishLevel)).forEach(p -> newStudArr.add(p));
        if (newStudArr.isEmpty()){
            System.out.println("Student at English Level " + englishLevel + " not found");
        }
        return newStudArr;
    }

    public ArrayList<?> searchByGradeLevelWithStream(String gradeLevel, ArrayList<?> personArr){

        /*This class searches for students or teachers by last name based
        on users choice at the main menu*/

        ArrayList<Student> newStudArr = new ArrayList<>();
        ArrayList<Teacher> newTeachArr = new ArrayList<>();

        //Try-Catch checks if user is searching for an ESOLStudent
        try{
            personArr.stream().filter(p -> ((ESOLStudent)p).getGradeLevel().equals(gradeLevel)).forEach(p -> newStudArr.add((ESOLStudent)p));
            if (newStudArr.isEmpty()){
                System.out.println("Student in Grade Level " + gradeLevel + " not found");
            }
            return newStudArr;//Return students ArrayList
        }
        catch (ClassCastException ignored){}

        //Try-Catch checks if user is searching for ESOLTeacher
        try {
            personArr.stream().filter(p -> ((Teacher)p).getGradeLevel().equals(gradeLevel)).forEach(p -> newTeachArr.add((Teacher)p));
            if (newTeachArr.isEmpty()){
                System.out.println("Teacher in Grade Level " + gradeLevel + " not found");
            }
            return newTeachArr;//Return teachers ArrayList
        }
        catch (ClassCastException ignored){}

        return null;
    }

    public ArrayList<Integer> searchByGradeLevel(String gradeLevel, ArrayList<?> personArr) {

        ArrayList<Integer> indexArr = new ArrayList<>();

        //Iterates through ArrayList of students or teachers comparing Grade Levels
        for (int i = 0; i < personArr.size(); i++) {

            //If grade level of student found, update index
            if (personArr.get(i) instanceof ESOLStudent) {
                if (((ESOLStudent) personArr.get(i)).getGradeLevel().equals(gradeLevel)) {
                    indexArr.add(i);
                }
            }

            //If grade level of teacher found, update index
            else if (personArr.get(i) instanceof ESOLTeacher) {
                if (((ESOLTeacher) personArr.get(i)).getGradeLevel().equals(gradeLevel)) {
                    indexArr.add(i);
                }
            }
        }
        return indexArr;
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
