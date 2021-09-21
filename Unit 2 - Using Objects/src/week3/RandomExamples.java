package week3;

public class RandomExamples {
    public static void main(String[] args) {
        double r = Math.random();
        System.out.println(r);      //random number between 0.0 and 1.0 (not including 1.0 - example 0.5373849)

        //r = (int)(r*10)+1; //generates random int number between 1-10;

        //random number between lower and upper bound
        int lower = -5;
        int upper = 5;

        int result = (int)((upper-lower+1)*r) + lower;


        String str = "Random numbers";

        //change a random character in the string to a x
        int index = (int)(Math.random()*str.length()); //returns number from 0-13

        str = str.substring(0, index) + "x" + str.substring(index+1);
        System.out.println(str);
    }
}
