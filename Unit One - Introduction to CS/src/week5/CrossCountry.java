package week5;

import java.util.Scanner;

public class CrossCountry {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        processRunner(in);
        processRunner(in);
        processRunner(in);

        in.close();
    }

    /**
     * The method processRunner, retrieves the input (first name, last name, times), and displays the information
     * @param in - in is a scanner variable
     */
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

        //get splitTwo time
        splitTwo = substractTimes(mileTwo, mileOne);
        //get splitThree time
        splitThree = substractTimes(finish, mileTwo);

        displayInfo(firstName, lastName, mileOne, splitTwo, splitThree, finish);
    }

    /**
     * The method subtractTimes finds the difference in times between two times (finds the split)
     * @param time2 - time2 is a String variable that carries the longer of two times in the format (min:seconds.milliseconds)
     * @param time1 - time1 is a String variable that carries the smaller of the two times in the format (min:seconds.milliseconds)
     * @return
     */
    private static String substractTimes(String time2, String time1) {
        double time1InSeconds = convertToSeconds(time1);
        double time2InSeconds = convertToSeconds(time2);

        //getDifferent and then build a new Time
        double newTime = time2InSeconds - time1InSeconds;
        String split = convertToMinutes(newTime);
        //newTime = (double)((int)(newTime*1000))/1000;
        //String split = Double.toString(newTime);
        return split;
    }

    /**
     * The method converToMinutes coverts the split time in seconds and it to a string 
     * @param newTime - A double variable parameter that represents the split time in seconds
     * @return - method returns the split time as a String in min:seconds.milliseconds format
     */
    private static String convertToMinutes(double newTime) {
        int min = (int)(newTime/60);
        double sec = newTime%100;
        String minute = Integer.toString(min);
        String split = Double.toString(sec);
        split = split.substring(0, split.indexOf(".")+4);
        return minute + ":" + split;
    }

    /**
     * The method convertToSeconds converts the input String time into seconds
     * @param time - passes the time in min:seconds.milliseconds format
     * @return - returns the time in seconds.milliseconds format as a double
     */
    private static double convertToSeconds(String time) {
        int minutes = getMinutes(time);
        double seconds = getSeconds(time);
        double totSeconds = (minutes*60 + seconds);
        return totSeconds;
    }

    /**
     * The method getMinutes retrieves the number of minutes in the string time
     * @param time - passes the time in min:seconds.milliseconds format
     * @return - returns the number of minutes in the String time as an integer (before the colon)
     */
    private static int getMinutes(String time) {
        int minute = Integer.parseInt(time.substring(0, time.indexOf(":")));
        return minute;
    }

    /**
     * The method getSeconds retrives the number of seconds and milliseconds in the string time
     * @param time - passes the time in min:seconds.milliseconds format
     * @return - returns the number of seconds and milliseonds in the String after the colon
     */
    private static double getSeconds(String time) {
        double seconds = Double.parseDouble(time.substring(time.indexOf(":")+1));
        return seconds;
    }

    /**
     * The method displayInfo displays the firstName, lastName, split 1, split 2, split 3, and finish time of the runner
     * @param firstName - passes through the first name of the runner
     * @param lastName - passes through the last name of the runner
     * @param mileOne - passes through mile one/split one time of the runner
     * @param splitTwo - passes through the split two time of the runner
     * @param splitThree - passes through the split three time of the runner
     * @param finish - passes through the final time of the runner
     */
    private static void displayInfo(String firstName, String lastName, String mileOne, String splitTwo,
            String splitThree, String finish) {
            System.out.println("");
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("Split one: " + mileOne);
            System.out.println("Split two: " + splitTwo);
            System.out.println("Split three: " + splitThree);
            System.out.println("Finish time: " + finish);
            System.out.println("");
    }
}
