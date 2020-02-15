package ESOLSMS;

import java.util.ArrayList;

public class GenericClass {

    //Prints results for student or teacher search
    public static <T> boolean printPerson(ArrayList<T> personArr, ArrayList<Integer> indexArr){
        for (int i =0; i < personArr.size();i++) {
            System.out.println(personArr.get(i));
        }
        //Return true to exit while loop
        return true;
    }
    public static <T> boolean printPersonv2 (ArrayList<T> personArr) throws NullPointerException{
         try {
             for (int i =0; i < personArr.size();i++) {
                 System.out.println(personArr.get(i));
             }
         }
         catch (NullPointerException e){
             System.out.println("Error, contact your Program Admin");
             e.printStackTrace();
         }

        //Return true to exit while loop
        return true;
    }

}
