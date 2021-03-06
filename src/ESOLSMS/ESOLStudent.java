package ESOLSMS;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;

public class ESOLStudent extends Student implements Serializable {
    /*ESOLStudent creates an object to represent this type of student
    * It is Serializable so it can be written to binary and sent to the UI*/

    private int studentId;
    private String englishLevel;
    private String firstLanguage;

    public ESOLStudent(String firstName, String lastName, String birthDate, String gradeLevel, int studentId,
                       String englishLevel, String firstLanguage) {
        super(firstName, lastName, birthDate, gradeLevel);
        this.studentId = studentId;
        this.englishLevel = englishLevel;
        this.firstLanguage = firstLanguage;
    }

    public int getStudentId(){
        return studentId;
    }

    public void setStudentId(int studentId){
        this.studentId = studentId;
    }

    public String getEnglishLevel() {
        return englishLevel;
    }

    public void setEnglishLevel(String englishLevel) {
        this.englishLevel = englishLevel;
    }

    public String getFirstLanguage() {
        return firstLanguage;
    }

    public void setFirstLanguage(String firstLanguage) {
        this.firstLanguage = firstLanguage;
    }
//
//    //Prints Teachers and Paraprofessionals
//    public void printTeachers() {
//        for (Teacher teach: teachers) {
//            if(teach instanceof ESOLTeacher){
//                System.out.printf("ESOL Teacher: %s %s %s\n",
//                        ((ESOLTeacher)teach).getTitle(),
//                        ((ESOLTeacher)teach).getFirstName(),
//                        ((ESOLTeacher)teach).getLastName());
//            }
//            else {
//                System.out.printf("ESOL Paraprofessional: %s %s %s\n",
//                        ((ESOLParaprofessional)teach).getTitle(),
//                        ((ESOLParaprofessional)teach).getFirstName(),
//                        ((ESOLParaprofessional)teach).getLastName());
//            }
//        }
//    }

    //Prints ESOLStudent object
    @Override
    public String toString() {
        int age = 0;
        try {
            age = calculateAge();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  "Name: " + getFirstName() + " " + getLastName() + "\n" +
                "English Level: " + englishLevel + "\n" +
                "FirstLanguage: " + firstLanguage +"\n" +
                "Age: " + age + "\n" +
                "Grade Level: " + getGradeLevel();
    }
}
