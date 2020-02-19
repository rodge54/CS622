package ESOLSMS;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ESOLStudentTeacherSearchTest {

    ESOLStudentTeacherSearch studentSearch = new ESOLStudentTeacherSearch();
    ArrayList<Student> studArr = new ArrayList<>();
    ArrayList<Teacher> teachersArr = new ArrayList<>();

    @Test
    public void searchByEnglishLevel() {
        //Should return an ArrayList with Integer 0 because 1 student was found when searching for grade 12 students
        studArr.add(new ESOLStudent("Robert","Rodgers",  "1987/09/13", "9", 1234, "2","Spanish", teachersArr));
        studArr.add(new ESOLStudent("Marika","Ruzzon",  "1987/09/13", "10",1234, "1","Spanish", teachersArr));
        assertEquals(studArr.get(0), studentSearch.searchByEnglishLevelWithStream("2", studArr).get(0));
    }

    @Test
    public void searchByGradeLevel() {
        //Should return an ArrayList with Integer 0 because 1 student was found when searching for grade 12 students
        studArr.add(new ESOLStudent("Robert","Rodgers",  "1987/09/13", "11",1234, "2","Spanish", teachersArr));
        studArr.add(new ESOLStudent("Marika","Ruzzon",  "1987/09/13", "12",1234, "2","Spanish", teachersArr));
        assertEquals(studArr.get(0), studentSearch.searchByGradeLevelWithStream("11", studArr).get(0));
    }

    @Test
    public void searchByLastName() {
        //Should return student because last name was found
        studArr.add(new ESOLStudent("Robert","Rodgers",  "1987/09/13", "11",1234, "2","Spanish", teachersArr));
        assertEquals(studArr.get(0), studentSearch.searchByLastNameWithStream("Rodgers", studArr).get(0));
    }

}