package week2;

/**
 * calculate the slope of a line given (x1, y1) and (x2,y2).
 */
public class Homework8 {
    public static void main(String[] args) {
        int x1 = 2, y1 = 3, x2 = 9, y2 = 7;
        double slope = (double)(y2 - y1) / (x2 - x1);
        System.out.println(slope);
    }
}
