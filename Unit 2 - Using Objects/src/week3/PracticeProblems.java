package week3;

public class PracticeProblems {
    public static void main(String[] args) {
        questionA();
        questionB();
        question5();
    }

    public static void questionA(){ //void because it wants to display not return
        int num = (int)(Math.random()*100)+1;
        System.out.println(num);
    }

    public static void questionB(){
        int num = (int)(Math.random()*100)-50;
        System.out.println(num);
    }

    public static void questionC(int num1, int num2){//provided that num2 is larger than num1
        int num = (int)(Math.random()*(num2-num1))+num1;
    }

    public static void question5(){
        int totalGames = 110 + 44;
        double winningPercentage = (int)((110.0 / totalGames)*1000) / 1000.0;
        System.out.println(winningPercentage);
    }
}
