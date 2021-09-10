package week1;

/**
 * More of the same
 * Assignment/Variables and Primitives
 */
public class ExampleFive {
    public static void main(String[] args) {
        int x=80, y, z; //variables of the same type can be assigned on the same line
        
        y = 75;
        z = 87;

        double average = (x + y + z)/3; //integer math if both operands are integers -> returns 80
        average = (x + y + z)/3.0; //double math if any of the operands are doubles -> returns 80.66667

        System.out.println(average);

    }
}
