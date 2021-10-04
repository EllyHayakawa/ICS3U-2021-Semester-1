package week5;

import java.util.Scanner;

public class CrossCountry {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        processRunner(in);
        //processRunner(in);
        //processRunner(in);

        in.close();
    }

    private static void processRunner(Scanner in) {
        String firstName, lastName;
        String mileOne, mileTwo, finish;
        String splitTwo, splitThree;

        //prompt user name
        System.out.print("Please enter your first name: ");
        firstName = in.nextLine();
        System.out.print("Please enter your last name: ");
        lastName = in.nextLine();

        //get MileOne time
        System.out.print("Please enter your mile one time: ");
        mileOne = in.nextLine();
        //get MileTwo time
        System.out.print("Please enter your mile two time: ");
        mileTwo = in.nextLine();
        //get finish time
        System.out.print("Please enter your finish time: ");
        finish = in.nextLine();

        /**
         * System.out.print("Please enter an integer: ");
        int num = 0;

        boolean validInput = false;

        while(!validInput){ //validInput == false (not true)
            try{
                num = Integer.parseInt(in.nextLine());
                validInput = true;
            }catch(Exception ex){
                System.out.print("Invalid input, please enter an integer: ");  
            }
        }
        System.out.println(Math.pow(num, 2));
    }
         */

        //get splitTwo time
        splitTwo = substractTimes(mileTwo, mileOne);
        //get splitThree time
        splitThree = substractTimes(finish, mileTwo);

        displayInfo(firstName, lastName, mileOne, splitTwo, splitThree, finish);
    }

    private static String substractTimes(String time2, String time1) {
        double time1InSeconds = convertToSeconds(time1);
        double time2InSeconds = convertToSeconds(time2);

        //getDifferent and then build a new Time
        double newTime = time2InSeconds - time1InSeconds;
        String split = Double.toString(newTime);
        return split;
    }

    private static double convertToSeconds(String time) {
        int minutes = getMinutes(time);
        double seconds = getSeconds(time);
        double totSeconds = (minutes*60 + seconds);
        return totSeconds;
    }

    private static int getMinutes(String time) {
        int minute = Integer.parseInt(time.substring(0, time.indexOf(":")));
        return minute;
    }

    private static double getSeconds(String time) {
        double seconds = Double.parseDouble(time.substring(time.indexOf(":")));
        return seconds;
    }

    private static void displayInfo(String firstName, String lastName, String mileOne, String splitTwo,
            String splitThree, String finish) {
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("Split one: " + mileOne);
            System.out.println("Split two: " + splitTwo);
            System.out.println("Split three: " + splitThree);
            System.out.println("Finish time: " + finish);
    }
}
