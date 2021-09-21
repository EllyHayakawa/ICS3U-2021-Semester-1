package week3;

/**
 * autoboxing
 * auto-unboxing
 */
public class WrapperClassExamples {
    public static void main(String[] args) {
        Integer n = new Integer(7);
        Double d = new Double(3.2);

        Integer num = 7;   //auto boxing
        int m = num;       //auto un-boxing

        int x = 6 + num;  // auto un-boxing so we can add a primitive and object (wrapper) together
        int y = m + num; 

        int z = num.intValue();  //num is the object, intValue() is a method to get the integer value for the object
        //same as int x = num;
        double f = d.doubleValue();

        System.out.println(Integer.MAX_VALUE);   //max value is constant (all uppercase)
        System.out.println(Integer.MIN_VALUE);   // static constants that represent the largest and smallest possible ints
    }
}
