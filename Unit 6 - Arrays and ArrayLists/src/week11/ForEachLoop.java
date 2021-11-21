package week11;

public class ForEachLoop {
    public static void main(String[] args) {
        int[] arr = {30, 20, 5, 70, 90, 80, 10};

        //for each is when you want to iterate through the whole array/ArrayList
        //Don't need the index
        //Cannot change the size of the arrayList (add or remove elements)

        int sum = 0;

        //for(var for next element : array / arrayList)
        for (int el : arr) {
            sum += el;        
        }

        String[] words = {"Test", "Alphabet", "Steve", "baseball", "Leafs"};

        String vowels = "aeiouAEIOU";
        int numVowels = 0;
        for(String w : words){
           for(int i = 0; i < w.length(); i++){
                String letter = w.substring(i, i+1);
                if(vowels.indexOf(letter) >= 0)
                    numVowels++;
           } 
        }
        System.out.println(numVowels);
    }
}
