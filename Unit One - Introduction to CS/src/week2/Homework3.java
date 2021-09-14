package week2;

/**
 * uses a five digit number and calculates the product of the 2nd and 4th digit. Use the modulus and and division operators.
 */
public class Homework3 {
    public static void main(String[] args) {
        int num = 12345;
        int fourthDigit = (num / 10) % 10;
        int secondDigit = (num / 1000) % 10;
        System.out.println(secondDigit*fourthDigit);
    }
}
