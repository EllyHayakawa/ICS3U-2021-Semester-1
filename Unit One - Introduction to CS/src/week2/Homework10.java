package week2;

/**
 * Math.sqrt(x), where x is a value can be used to calculate the square root. 
 * Given an equation in the format from question 7.  
 * Obtain the two roots. given a, b, c
 */
public class Homework10 {
    public static void main(String[] args) {
        double a = 2, b = 10, c = 4; 
        double root1 = (-b + (Math.sqrt((b * b) - 4 * a * c)))/(2 * a);
        double root2 = (-b - (Math.sqrt((b * b) - 4 * a * c)))/(2 * a);
        System.out.println ("(" + root1 + ", " + root2 + ")");
        
    }
}
