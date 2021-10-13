package week6;

public class ProgrammingContest {
    public static void main(String[] args) {
        framingSquares(3, 4, 1, 2);
        diamonds("CANADA");
        wordFrame("CANADA");
    }

    private static void wordFrame(String str) {
        //first row
        System.out.println("*" + str + "*");
        //middle rows
        for(int i = 0; i < str.length(); i++){
            String lastLetter = str.substring(str.length()- i - 1, str.length() - i);
            String firstLetter = str.substring(i, i+1);
            System.out.print(lastLetter);
            for(int j = 0; j < str.length(); j++){
            System.out.print("*");
            }
            System.out.println(firstLetter);
        }
        //last row
        System.out.print("*");
        for(int i = 0; i < str.length(); i++){
            String lastLetter = str.substring(str.length()- i - 1, str.length() - i);
            System.out.print(lastLetter);
        }
        System.out.println("*");
    }

    private static void diamonds(String str) {
        //Forward
        for(int i = 1; i < str.length(); i++){
            System.out.print(" ");
        }
        System.out.println(str.substring(0, 1));
        for(int i = 1; i < str.length(); i++){
            String letter = str.substring(i, i + 1);
            for(int j = 0; j < str.length()- i - 1; j++){
                System.out.print(" ");
            }
            System.out.print(letter);
            for(int j = 0; j < (2*i-1); j++){
                System.out.print(" ");
            }
            System.out.print(letter);
            
            System.out.println();
        }

        //Backward

        for(int i = str.length()-2; i > 0; i--){ //make the for loop move backwards (but don't include the last letter - because it overlaps)
            String letter = str.substring(i, i + 1);
            for(int j = 0; j < str.length()- i - 1; j++){
                System.out.print(" ");
            }
            System.out.print(letter);
            for(int j = 0; j < (2*i-1); j++){
                System.out.print(" ");
            }
            System.out.print(letter);
            
            System.out.println();
        }
        for(int i = 1; i < str.length(); i++){
            System.out.print(" ");
        }
        System.out.println(str.substring(0, 1));
    }

    /**
     * @param M - height of picture
     * @param N - width of picture
     * @param P - padding/margin width
     * @param Q - frame width
     */
    private static void framingSquares(int M, int N, int P, int Q) {
        //Top part of the frame
        for(int i = 0; i < Q; i++){ //will happen Q times
            for(int j = 0; j < (N+2*P+2*Q); j++){
                System.out.print("#");
            }
            System.out.println();
        }

        //Frame + Padding + Frame
        for(int i = 0; i < P; i++){ //happens P times (number of rows it needs to be done)
            //Frame
            for(int j = 0; j < Q; j++){
                System.out.print("#");
            }
            //Padding
            for(int j = 0; j < 2*P+N; j++){
                System.out.print("+");
            }
            //Frame
            for(int j = 0; j < Q; j++){
                System.out.print("#");
            }
            System.out.println();
        }

        //Frame + Padding + Picture + Padding + Frame
        for(int i = 0; i < M; i++){
            //Frame
            for(int j = 0; j < Q; j++){
                System.out.print("#");
            }
            //Padding
            for(int j = 0; j < P; j++){
                System.out.print("+");
            }
            //Picture
            for(int j = 0; j < N; j++){
                System.out.print("•");
            }
            for(int j = 0; j < P; j++){
                System.out.print("+");
            }
            for(int j = 0; j < Q; j++){
                System.out.print("#");
            }
            System.out.println();
        }

        //Frame + Padding + Frame
        for(int i = 0; i < P; i++){ //happens P times (number of rows it needs to be done)
            //Frame
            for(int j = 0; j < Q; j++){
                System.out.print("#");
            }
            //Padding
            for(int j = 0; j < 2*P+N; j++){
                System.out.print("+");
            }
            //Frame
            for(int j = 0; j < Q; j++){
                System.out.print("#");
            }
            System.out.println();
        }

        //Top part of the frame
        for(int i = 0; i < Q; i++){ //will happen Q times
            for(int j = 0; j < (N+2*P+2*Q); j++){
                System.out.print("#");
            }
            System.out.println();
        }
        
    }


}
