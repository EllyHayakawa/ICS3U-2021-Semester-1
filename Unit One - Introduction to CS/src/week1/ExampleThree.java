package week1;
/**
 * Strings and Escape Sequences
 */
public class ExampleThree {
    public static void main(String[] args) {
        //System.out.println("This is"very" special"); //compile error

        System.out.println("This is \"very\" special");//we use back slash to escape special characters
        
        //System.out.println("This is \very special"); //cannot escape v it is not an escape sequence

        System.out.println("This\nis\nvery\nspecial");// \n is a new line
        System.out.println("This is \\very special");//if we want a backslash we need to escape it

    }
}
