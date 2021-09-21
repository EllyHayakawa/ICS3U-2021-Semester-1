package week3;

/**
 * everything in math class is static
 */
public class MathClassExamples {
    public static void main(String[] args) {
        double a = -7.8;

        System.out.println(Math.abs(a)); //method was called through class -> Math.abs is static

        System.out.println(Math.sqrt(10));

        double num = Math.pow(2, 4); //(base, exponent) (2 to the power of 4)
        System.out.println(num);

    }
}
