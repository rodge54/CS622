package ESOLSMS;

import java.util.ArrayList;

public class ESOLParaprofessional extends Teacher {
    private ArrayList<String> languagesSpoken;
    private boolean WIDACertified = false;
    private boolean imagineLearningCertified = false;

    public ESOLParaprofessional(String firstName, String lastName, String emailAddress, String title, String gradeLevel,
                                ArrayList<String> languagesSpoken, boolean WIDACertified,
                                boolean imagineLearningCertified) {
        super(firstName, lastName, emailAddress, gradeLevel, title);
        this.languagesSpoken = languagesSpoken;
        this.WIDACertified = WIDACertified;
        this.imagineLearningCertified = imagineLearningCertified;
    }

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

        return "***ESOLTeacher*** \n" +
                "Name: " + getTitle() + " " + getFirstName() + " " + getLastName() + "\n" +
                "Email Address: " + getEmailAddress() + "\n" +
                "Grade Level: " + getGradeLevel() +"\n" +
                "Languages Spoken: " + "\n" +
                "Awaiting implementation"
                ;
    }
}
