package week3;

public class UnitTest {
    public static void main(String[] args) {
        System.out.println(twoChar("Happy", 1));
        System.out.println(twoChar("Computer Science", 4));

        System.out.println(removeChars("Happy", 1, 2));
        System.out.println(removeChars("Computer Science", 4, 5));

        System.out.println(sqrtSum(9999));
    }

    /**
     * prints 3 copies of a substring (2chars) in str starting at index
     * Example: twoChar('Happy', 1) => "apapap"
     */
    public static String twoChar(String str, int index){
        String seg = str.substring(index, index + 2);
        return seg + seg + seg;
    }
    
    /**
     * remove chars ("Happy", 1, 2) => Hpy (from index 1 remove 2 char)
     */
    public static String removeChars(String str, int index, int n){
        String first = str. substring(0, index);
        String second = str.substring(index + n);
        return first + second;
        
    }

    public static double sqrtSum(int number){
        int n1 = number / 1000;  //         2457/1000 = 2
        int n2 = number / 100 % 10;   //    2457 / 100 = 24 % 10 = 4
        int n3 = number / 10 % 10;  //       2457 / 10 = 245 % 10 = 5
        int n4 = number % 10;    //          2457 % 10 = 7
        return Math.sqrt(n1 + n2 + n3 + n4);
    }
}
