package week6;

public class CompareToExample {
    public static void main(String[] args) {
        System.out.println("abce".compareTo("bcd")); //"bcd" > "abcd"
        //compareTo looks at which string is bigger (comes first alphabetically -> smaller)

        System.out.println("a".compareTo("g")); //a is 1, g is 7 (1-7 = -6)
        System.out.println("g".compareTo("a")); //returns 6
        System.out.println("g".compareTo("g")); //returns 0
        System.out.println("g".compareTo("G")); //+32

        //returns 0 (when the two things being compared are the same), 
        //a negative number (if this(i.e. the object that called the method) is smaller than the argument),
        //positive number (if 'this' is bigger than the argument)

        /**
         * compareTo -> compares the ASCII decimal code difference
         */

         System.out.println("go".compareTo("get"));  //"go" is bigger than "get" because "o" is bigger than "e" (doesn't use the "t")

         System.out.println("go".compareTo("goo"));  // goo is bigger than go (-1)
         System.out.println("goo".compareTo("go"));  // goo is bigger than go (1)
    }
}
