package ESOLSMS;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ESOLStudentTeacherSearch{

    public String searchTeacherOfStudent( String studentFirstName, String studentLastName, ArrayList<Teacher> teachersArr){

        String teacher = "Ms. Marika";
        System.out.println("Find ESOL STUDENT's teacher in progress...");
        System.out.println("Awaiting Implementation");
        return teacher;
    }

    public ArrayList<Integer> searchByEnglishLevel(String englishLevel, ArrayList<Student> studArr){
        ArrayList<Integer> indexArr = new ArrayList<>();

        //Iterates through ArrayList of students comparing Grade Levels
        for (int i = 0; i < studArr.size(); i++){

            //If Last Name is found return student Object
            if(((ESOLStudent)studArr.get(i)).getEnglishLevel().equals(englishLevel)){
                indexArr.add(i);
            }
        }
        return indexArr;
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

    public ArrayList<Integer> searchByLastName(String name, ArrayList<?> personArr) {

        ArrayList<Integer> indexArr = new ArrayList<>();

        //Iterates through ArrayList of students or teachers comparing Last Names
        for (int i = 0; i < personArr.size(); i++){

            //If Last Name of student found, update index
            if (personArr.get(i) instanceof ESOLStudent) {
                if (((ESOLStudent)personArr.get(i)).getLastName().equals(name)) {
                    indexArr.add(i);
                }
            }

            //If Last Name of teacher found, update index
            else if (personArr.get(i) instanceof ESOLTeacher) {
                if (((ESOLTeacher) personArr.get(i)).getLastName().equals(name)) {
                    indexArr.add(i);
                }
            }
        }
        return indexArr;
    }
}
