package ESOLSMS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Student {

    private String firstName;
    private String lastName;
    private String birthDate;
    private String gradeLevel;

    public Student(String firstName, String lastName, String birthDate, String gradeLevel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gradeLevel = gradeLevel;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    //Calculates age of student based on DOB yyyy/mm/dd
    public int calculateAge() throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date birthDate = null;
        try{
            birthDate = dateFormat.parse(getBirthDate());
        }
        catch (ParseException e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthDate);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);
        LocalDate parsedBday = LocalDate.of(year, month, date);
        LocalDate currentDate = LocalDate.now();
        Period difference = Period.between(parsedBday, currentDate);
        return difference.getYears();
    }
}
