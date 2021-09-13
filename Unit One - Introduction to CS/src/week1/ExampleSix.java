package week1;

/**
 * final modifier - used to make a variable constant
 */
public class ExampleSix {
    public static void main(String[] args) {
        final int x = 7;
        //x = 8;   syntax because we cannot reassign a value to a variable that has been modified with final
        final int y;
        y = x;  // no issue because this is the first time we are assigning a value to y

        final int NUMBER_OF_STUDENTS = 30;  //naming convention of constants is all caps and _ for spaces
       
    }
}