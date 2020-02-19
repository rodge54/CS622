package ESOLSMS;

public class Teacher {
    /*Teacher sets base parameters for different types of teachers
     * It is Serializable so it can be written to binary and sent to the UI*/

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String title;
    private String gradeLevel;

    public Teacher(String firstName, String lastName, String emailAddress, String title, String gradeLevel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.title = title;
        this.gradeLevel = gradeLevel;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getTitle() {
        return title;
    }

    public String getGradeLevel(){
        return gradeLevel;
    }

    public void setGradeLevel(){
        this.gradeLevel = gradeLevel;
    }

}
