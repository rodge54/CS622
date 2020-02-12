package ESOLSMS;

import java.util.ArrayList;

public class GenericClass {

    //Prints results for student or teacher search
    public static <T> boolean printPerson(ArrayList<T> personArr, ArrayList<Integer> indexArr){
        for (int index : indexArr) {
            System.out.println(personArr.get(index));
        }
        //Return true to exit while loop
        return true;
    }
}
