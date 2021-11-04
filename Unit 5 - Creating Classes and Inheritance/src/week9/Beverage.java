package week9;

public class Beverage {
    private int numOunces; //belongs to instances
    private static int numSold = 0; //belongs to class

    public Beverage(int numOz){
        numOunces = numOz;
    }

    public static void sell(int n){
        numSold += n;
        //numOunces += n; //static methods do NOT have access to non-static attributes or non-static methods
    }
}
