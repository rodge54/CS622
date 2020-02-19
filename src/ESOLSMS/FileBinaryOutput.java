package ESOLSMS;

import java.io.*;
import java.util.ArrayList;

public class FileBinaryOutput {
    /*Converts data to binary to send to front end*/

    public static void ESOLStudentToBinaryFile(ArrayList<Student> studArr) {
        /*This method reads in Array of Students and writes to binary.
        When student is searched it is pulled from database, written to binary
        here and then sent to frontend for processing*/

        String fileName = "ESOLstudent.dat";
        try (ObjectOutputStream outfile = new ObjectOutputStream(
                new FileOutputStream(fileName))) {
            for (Student stud :studArr ) {
                outfile.writeObject(stud);
            }
            System.out.println("Written to Binary");
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Student> inputFromBinaryFile() throws NullPointerException {
        //Sends student array from binary file to frontend

        String fileName = "ESOLstudent.dat";
        ArrayList<Student> studArr = new ArrayList<>();

        try (ObjectInputStream infile = new ObjectInputStream(
                new FileInputStream(fileName))) {
            while (true) {
                try {
                    studArr.add((ESOLStudent) infile.readObject());
                }
                catch (EOFException ex) {
                    break; //EOF Reached
                }
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return studArr;
    }
}
