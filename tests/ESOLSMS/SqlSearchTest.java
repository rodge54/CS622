package ESOLSMS;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class SqlSearchTest {

    @Test
    public void queryByLastName() {
        ArrayList<Student> studArr = new ArrayList<>();
        Student bugs = new ESOLStudent("Bugs","Bunny","1940/07/27", "12",1234,"1", "English");
        studArr.add(bugs);
        SqlSearch sqlSearch = new SqlSearch();

        //Test
        assertEquals(bugs.toString(),sqlSearch.queryByLastName("Bunny",1).get(0).toString());
    }

    @Test
    public void queryByEnglishLevel() {
        ArrayList<Student> studArr = new ArrayList<>();
        Student tweety = new ESOLStudent("Tweety", "Bird", "1941/11/12", "7", 4569, "3", "English");
        studArr.add(tweety);
        SqlSearch sqlSearch = new SqlSearch();

        //Test
        assertEquals(tweety.toString(), sqlSearch.queryByEnglishLevel("3", 1).get(0).toString());
    }

    @Test
    public void queryByGradeLevel() {
        ArrayList<Student> studArr = new ArrayList<>();
        Student tweety = new ESOLStudent("Tweety", "Bird", "1941/11/12", "7", 4569, "3", "English");
        studArr.add(tweety);
        SqlSearch sqlSearch = new SqlSearch();

        //Test
        assertEquals(tweety.toString(), sqlSearch.queryByGradeLevel("7", 1).get(0).toString());

    }
}