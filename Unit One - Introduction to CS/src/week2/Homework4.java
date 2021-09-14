package week2;

/**
 * 	calculate the final velocity of a car given the initial velocity, the acceleration of the car and the time that has elapsed using the following equation:
vf= vi+at

 */
public class Homework4 {
    public static void main(String[] args) {
        int initVelocity = 60;
        int a = 20;
        double time = 90;
        double finVelocity = (initVelocity + (a * time));
        System.out.println(finVelocity);
    }
}
