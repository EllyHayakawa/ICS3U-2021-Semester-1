package week2;

/**
 * obtains two integers, one for the amount a test is out of and another indicating what a student received
 * display what percentage the student received on the test
 */
public class Homework2 {
    public static void main(String[] args) {
        int studentScore = 27;
        double totalScore = 35;
        double percentageScore = (studentScore/totalScore) * 100;
        System.out.println("The student's score is " + percentageScore + "%"); //should the percentage score be rounded?
    }
}
