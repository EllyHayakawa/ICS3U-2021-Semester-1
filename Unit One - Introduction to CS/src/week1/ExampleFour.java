package week1;

/**
 * Variables  //stores information/data 
 * Primitive Data Types (int / double / char / boolean)
 * Assignment Operator - assigns a value to a variable (assignment operator =)
 */
public class ExampleFour {
    public static void main(String[] args) {
        int markOne = 75; //declared an integer variable called markOne that stores the value 75

        int markTwo = 80;
        int markThree = 87;

        int average; //declared a variable and did not asssign a value
        average = (markOne + markTwo + markThree)/3;

        System.out.println(average);

        System.out.println("The average of the marks is: " + average); //join strings and ints and other primitive data types using + 


    }
}
