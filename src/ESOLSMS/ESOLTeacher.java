package ESOLSMS;

import java.io.Serializable;
import java.util.ArrayList;

public class ESOLTeacher extends Teacher implements Serializable {
    /*ESOLTeacher creates an object to represent this type of teacher
     * It is Serializable so it can be written to binary and sent to the UI*/

    private ArrayList<String> languagesSpoken;

    public ESOLTeacher(String firstName, String lastName, String emailAddress, String title, String gradeLevel, ArrayList<String> languagesSpoken) {
        super(firstName, lastName, emailAddress, title, gradeLevel);
        this.languagesSpoken = languagesSpoken;
    }

    public void getLanguagesSpoken() {
        System.out.printf("***%s %s %s speaks***\n", getTitle(), getFirstName(), getLastName());
        //Print spoken languages from array
        for (String lang: languagesSpoken) {
            System.out.println(lang);
        }
        System.out.println("**********************");
    }

    //Prints ESOLStudent object
    @Override
    public String toString() {

        return "***ESOLTeacher*** \n" +
                "Name: " + getTitle() + " " + getFirstName() + " " + getLastName() + "\n" +
                "Email Address: " + getEmailAddress() + "\n" +
                "Grade Level: " + getGradeLevel() +"\n" +
                "Languages Spoken: " + "\n" +
                "Awaiting implementation"
                ;
    }
}
