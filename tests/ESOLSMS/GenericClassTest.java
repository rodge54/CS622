package ESOLSMS;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GenericClassTest {

    @Test
    public void printPerson() {
        ArrayList<Student> studArr = new ArrayList<>();
        ArrayList<Teacher> teachArr = new ArrayList<>();
        ArrayList<Integer> indexArr = new ArrayList<>();
        //Test with students Array
        assertTrue(GenericClass.printPerson(studArr,indexArr));
        //Test with teachers Array
        assertTrue(GenericClass.printPerson(teachArr,indexArr));

    }
}