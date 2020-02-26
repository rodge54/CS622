package ESOLSMS;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    /*Runs ESOL-SMS program with no UI*/

    public static void main(String[] args) throws InterruptedException {

//       *****************************************MAIN PROGRAM START************************************************
        //Print Welcome Message
        Menus.welcomeMessage();

        //Create Tables for ESOLSMS database
        SqlUpdates.createStudentTables();
        SqlUpdates.createESOLStudentTables();
        SqlUpdates.createTeacherTables();

        int i;
        boolean correct = false;

        while(!correct){

            Menus.startMenu();

            Scanner sc = new Scanner(System.in);//New Scanner
            int userInput1 = 0;

            //Checks that selection from numbered list is correct
            try{
                userInput1 = sc.nextInt();
            }

            catch (InputMismatchException e){
                System.out.println("Not in list, please enter new number");
                TimeUnit.SECONDS.sleep(2);
            }

            sc = new Scanner(System.in);//New scanner
            String userInput2;

            //Variables indicate if searching for teacher or student
            int studIndicator = 1;
            int teachIndicator = 2;
            SqlSearch sqlSearch = new SqlSearch();

            //Each Menu Item is represented through switch cases
            switch (userInput1){

                case 1:
                    System.out.println("Please enter the Last Name of Students you would like to find: ");
                    userInput2 = sc.nextLine();
                    correct = GenericClass.printPersonv2(sqlSearch.queryByLastName(userInput2, studIndicator));
                    break;

                case 2:
                    System.out.println("Please enter the English Level of Student's you would like to find: ");
                    userInput2 = sc.nextLine();
                    correct = GenericClass.printPersonv2(sqlSearch.queryByEnglishLevel(userInput2, studIndicator));
                    break;

                case 3:
                    System.out.println("Please enter the Grade Level of Students you would like to find: ");
                    userInput2 = sc.nextLine();
                    correct = GenericClass.printPersonv2(sqlSearch.queryByGradeLevel(userInput2, studIndicator));
                    break;

                case 4:
                    Edit edit = new Edit();
                    edit.addESOLStudent();
                    correct = true;
                    break;

                case 5:
                    System.out.println("Please enter the Grade Level of Teachers you would like to find: ");
                    userInput2 = sc.nextLine();
                    correct = GenericClass.printPersonv2(sqlSearch.queryByGradeLevel(userInput2, teachIndicator));
                    break;

                case 6:
                    System.out.println("Please enter the Last Name of Teachers you would like to find: ");
                    userInput2 = sc.nextLine();
                    correct = GenericClass.printPersonv2(sqlSearch.queryByLastName(userInput2, teachIndicator));
                    break;

                case 7:
                    System.out.println("Thank you for using ESOL-SMS");
                    correct = true;
                    break;

                default:
                    System.out.println("Not in list, please enter new number");
                    TimeUnit.SECONDS.sleep(2);
            }
            sc.close();//Close Scanner
        }
    }
}
