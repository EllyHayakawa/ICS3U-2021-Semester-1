package week4;

public class IfStatementExamples {
    public static void main(String[] args) {
        exampleOne();
        exampleTwo(75);
        exampleThree();
    }
    
    private static void exampleOne() {
        /**
         if (boolean expression is true){
          // do this
         }
         */
         int x = 7;
         
         if(x % 2 == 0){ 
            System.out.println(x + " is even!");
         }else{
             System.out.println(x + " is odd!");
         }
    }
    private static void exampleTwo(int mark) {

         if (mark >= 90){
            System.out.println("A+");
        }else if(mark >= 80){
            System.out.println("A");
        }else if(mark >= 70){
            System.out.println("B");
        }else if(mark >= 60){
            System.out.println("C");
        }else if(mark >= 50){
            System.out.println("D");
        }else{
            System.out.println("F");
        }
    }

    private static void exampleThree() {
        // OR -> ||   (x>7 || y>7) // if x >7 OR y>7 it is true

        // AND -> &&  (x?7 && y>7) // if x>7 AND y>7 it is true

        /**
         * >
         * <
         * >=
         * <=
         * ==  (don't use with strings)
         * !=  (not equals)
         * !(x>7)  x is NOT bigger than 7 (x <= 7)
         */
    }

}
