package week2;

/**
 * given the number of pennies, nickles, dimes, quarters, loonies and toonies calculates how much money the user has.
 */
public class Homework9 {
    public static void main(String[] args) {
        double pennies = 7, nickles = 4, dimes = 8, quarters = 2, loonies = 9, toonies = 4;
        double totalMoney = (toonies * 2) + loonies + (quarters * 25)/100 + (dimes * 10)/100 + (nickles * 5)/100 + (pennies / 100);
        System.out.println("The user has $" + totalMoney);
    }
}
