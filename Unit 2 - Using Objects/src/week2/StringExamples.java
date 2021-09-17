package week2;

public class StringExamples {
    public static void main(String[] args) {

        //Defined 3 references to String objects

        //When we use a String literal we are NOT constructing an instance of an Object
        String stringLiteral = "This is a String Literal";
        String anotherLiteral = "This is a String Literal";

        //The following 3 create 3 seperate instances of String Objects
        String somethingDifferent = new String("This is a String Literal"); //I am lying
        String somethingDifferent1 = new String("This is a String Literal");
        String somethingDifferent2 = new String("This is a String Literal");

        System.out.println(stringLiteral.length()); // the last index is one less than the length of the String
        System.out.println(stringLiteral.equals(somethingDifferent)); //true if the same sequence of characters is in stringLiteral and somethingDifferent, otherwise false
        
        System.out.println(stringLiteral.indexOf("in")); //returns the index of the first occurrence of whatever is passed through
        System.out.println(stringLiteral.indexOf("happy")); //if it does not occur, it returns -1
        
        System.out.println(stringLiteral.substring(3));//returns the string starting at the integer //will return 's is a String Literal'
        System.out.println(stringLiteral.substring(3, 6));//returns the string starting at the first number, ending up to but NOT including the last number ([startIndex], finalIndex) //returns 's i'
    }
}
