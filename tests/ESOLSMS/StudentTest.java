package ESOLSMS;

import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void calculateAge() throws ParseException {
        ArrayList<Teacher> teachersArr = new ArrayList<>();
        ArrayList<Student> studArr = new ArrayList<>();
        studArr.add(new ESOLStudent("Robert","Rodgers",  "1987/09/13", "11", 1234, "2","Spanish"));
        assertEquals(32, studArr.get(0).calculateAge());
    }
}