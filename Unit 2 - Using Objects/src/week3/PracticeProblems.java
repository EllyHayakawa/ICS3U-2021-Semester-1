package week3;

public class PracticeProblems {
    public static void main(String[] args) {
        //questionA();
        //questionB();
        //questionC(2, 6); //num2 must be bigger than num1
        //questionD();
        //System.out.println(question1a("letter"));
        //System.out.println(question1b("Hamburger", "Ham"));
        //System.out.println(question1c("Hi", "Hello"));
        //System.out.println(question1d(4, 2, 8, 10));
        //question1e(4, 7);
        //question1f("Hello World");
        //question1();
        //question2();
        //question3();
        //question4();
        //question5();
        //question6();
        //question7();
        //question8(15678.0);
        //question9(28);
        //question10(6.7, 2.5);
        question11(56, 46.7);
    }

    /**
     * obtain int between 1-100 (inclusive) and display
     */
    public static void questionA(){ //void because it wants to display not return
        int num = (int)(Math.random()*100)+1;
        System.out.println(num);
    }

    /**
     * obtain int between -50 and 50 (inclusive) and display
     */
    public static void questionB(){
        int num = (int)(Math.random()*101)-50;
        System.out.println(num);
    }

    /**
     * provided 2 nums, display random number between those two (inclusive) 
     */
    public static void questionC(int num1, int num2){//provided that num2 is larger than num1
        int num = (int)(Math.random()*((num2-num1)+1))+num1;
        System.out.println(num);
    }

    /**
     * simulate 6-sided die - display to console
     */
    public static void questionD(){
        int num = (int)(Math.random()*6)+1;
        System.out.println("You rolled: " + num);
    }

    /**
     * accept a String and return a substring with the first "e" removed
     */
    public static String question1a(String str){
        int index = str.indexOf('e');
        str = str.substring(0, index) + str.substring(index+1);
        return str;
    }

    /**
     * accepts a String and a substring -> return a String with the second string removed from the first String
     */
    public static String question1b(String str, String sb){
        int index = str.indexOf(sb);
        str = str.substring(0, index) + str.substring(index + sb.length());
        return str;
    }

    /**
     * accepts two Strings and returns the length of the two strings added together
     */
    public static int question1c(String str1, String str2){
        int fs = str1.length();
        int ss = str2.length();
        return (fs+ss);
    }

    /**
     * take 4 integers (x1,y1, x2,y2) and obtains slope of the line connecting those two
     * the slope is NOT simplified
     */
    public static String question1d(int x1, int y1, int x2, int y2){
        int numerator = (y2 - y1);
        int denominator = (x2 - x1);
        return numerator + "/" + denominator;
    }

    /**
     * Calculate the volume of a cylinder
     * Radius and Height are the parameters
     * Rounded to 2 decimal places
     */
    public static void question1e(double r, double h){
        final double pi = Math.PI;
        double volume = pi * (r*r) * h;
        volume = (double)((int)(volume*100))/100;
        System.out.println("The volume of the cylinder is " + volume + "cm^3");
    }

    /**
     * removes a random character from a String and returns the new string
     */
    public static void question1f(String str){
        int index = (int)(Math.random()*(str.length()+1));
        str = str.substring(0, index) + str.substring(index+1);
        System.out.println(str);
    }


    public static void question1(){
        int p = 985;
        double tax = (5.5/100)+1;
        double tprice = (double)((int)((p*tax)*100))/100;
        System.out.println("The total price is $" + tprice);
    }

    public static void question2(){
        double length = 4.5;
        double width = 2.3;
        double area = (double)((int)((length*width)*10))/10;
        double perimeter = (double)((int)((2*length + 2*width)*10))/10;
        System.out.println("The area of the rectangle is " + area + "ft, the perimeter is " + perimeter + "ft");
    }

    public static void question3(){
        int min = 60*24;
        System.out.println(min*365 + " minutes in a year");
    }

    public static void question4(){
        double speed = 3*(Math.pow(10, 8));
        double t = 365*24*60*60;
        double d = speed*t;
        System.out.println("Light travels " + d/100000000000.0 + "*(10^15) metres in a year.");
    }

    public static void question5(){
        int totalGames = 110 + 44;
        double winningPercentage = (int)((110.0 / totalGames)*1000) / 1000.0;
        System.out.println(winningPercentage);
    }

    public static void question6(){
        int mass = 10;
        int velocity = 12;
        int momentum = mass*velocity;
        System.out.println(momentum);
    }

    public static void question7(){
        int f = 98;
        int c = (int)((f-32)*(5.0/9));
        System.out.println(c);
    }

    public static void question8(double num){
        double square = (Math.pow(num, 2));
        double sqrt = Math.sqrt(num);
        System.out.println("Square: " + square + "  Square root: "+ sqrt);
    }

    public static void question9(int numSold){
        double pay = (double)((int)((0.27*numSold)*100))/100;
        System.out.println("$" + pay);
    }

    public static void question10(double length, double width){
        double area = (length*width);
        double perimeter = (2*length + 2*width);
        System.out.println("The area of the rectangle is " + area + ", the perimeter is " + perimeter);
    }

    public static void question11(double m, double v){
        double kE = (0.5*m*(Math.pow(v, 2)));
        System.out.println("The kinetic energy is" + kE);
    }
}
