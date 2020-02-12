package ESOLSMS;

public class Menus {

    public static void welcomeMessage(){
        System.out.println("*******************************************");
        System.out.println("************WELCOME TO ESOL-SMS************");
        System.out.println("*******************************************\n");
    }

    public static void startMenu(){
        System.out.println("Please choose a number from below:\n" +
                "\t1. Search by student’s Last Name\n" +
                "\t2. Search by student’s English speaking level\n" +
                "\t3. Search by student’s grade level\n" +
                "\t4. Add new Student\n" +
                "\t5. Search for teacher by Grade Level\n" +
                "\t6. Search for teacher by Last Name\n");

//                  Not yet implemented
//                 +
//                "\t5. Update Student information\n" +
//                "\t6. Add new Teacher\n" +
//                "\t7. Update Teacher information\n");
    }

}
