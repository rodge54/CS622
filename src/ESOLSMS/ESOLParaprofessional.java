package ESOLSMS;

import java.io.Serializable;
import java.util.ArrayList;

public class ESOLParaprofessional extends Teacher implements Serializable {
    /*ESOLParaprofessional creates an object to represent this type of teacher
    * It is Serializable so it can be written to binary and sent to the UI*/

    private ArrayList<String> languagesSpoken;
    private boolean WIDACertified = false;
    private boolean imagineLearningCertified = false;

    public ESOLParaprofessional(String firstName, String lastName, String emailAddress, String title, String gradeLevel,
                                ArrayList<String> languagesSpoken, boolean WIDACertified,
                                boolean imagineLearningCertified) {
        super(firstName, lastName, emailAddress, title, gradeLevel);
        this.languagesSpoken = languagesSpoken;
        this.WIDACertified = WIDACertified;
        this.imagineLearningCertified = imagineLearningCertified;
    }

    //Awaiting Implementation
    public void getLanguagesSpoken() {
        System.out.printf("***%s %s %s speaks***\n", getTitle(), getFirstName(), getLastName());
        //Print spoken languages from array
        for (String lang: languagesSpoken) {
            System.out.println(lang);
        }
        System.out.println("**********************");
    }

    public void setLanguagesSpoken(ArrayList<String> languagesSpoken) {
        this.languagesSpoken = languagesSpoken;
    }

    public boolean isWIDACertified() {
        return WIDACertified;
    }

    public void setWIDACertified(boolean WIDACertified) {
        this.WIDACertified = WIDACertified;
    }

    public boolean isImagineLearningCertified() {
        return imagineLearningCertified;
    }

    public void setImagineLearningCertified(boolean imagineLearningCertified) {
        this.imagineLearningCertified = imagineLearningCertified;
    }

    //Prints ESOLPara object
    @Override
    public String toString() {

        return "***ESOLParaProfessional*** \n" +
                "Name: " + getTitle() + " " + getFirstName() + " " + getLastName() + "\n" +
                "Email Address: " + getEmailAddress() + "\n" +
                "Grade Level: " + getGradeLevel() +"\n" +
                "Languages Spoken: " + "\n" +
                "Awaiting implementation"
                ;
    }
}
