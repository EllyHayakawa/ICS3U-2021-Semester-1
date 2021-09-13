package week1;

/**
 * Type Casting (Primitives)
 */
public class ExampleEight {

    public static void main(String[] args) {
        final int NUM_MARKS = 5;
        int markOne = 84, markTwo = 78, markThree = 87, markFour = 97, markFive = 63;

        //Cast the int NUM_MARKS as a double for the purpose of the calculation
        double average = (double)(markOne + markTwo + markThree + markFour + markFive)/NUM_MARKS;

        System.out.println("The average is:" + average);

        //int y = 7.3;  //type mismatch

        //int y = (double)3; //same error as above

        double z = 4.5;
        int y = (int) z;

        //narrow conversion  double -> int
        //widen conversion   int -> double
    }
}
