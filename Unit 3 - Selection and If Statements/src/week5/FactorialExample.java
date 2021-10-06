package week5;

public class FactorialExample{
    public static void main(String[] args) {
        int result = factorial(7);
        System.out.println(result);
        int result1 = fibonacci(5);
        System.out.println(result1);
    }

    private static int factorial(int n){

        //7! = 7 x 6 x 5 x 4 x 3 x 2 x 1

        //7! = 7 x 6!

        if(n == 1){
            return 1;
        }else{
            return n*(factorial(n-1));
        }

    }

    private static int fibonacci(int n){
        if(n==1||n==2){
            return 1;
        }else{
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}
