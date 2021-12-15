package week16;

public class Arrays2D {
    public static void main(String[] args) {
        int[][] arr2D = new int[4][3];
        int counter = 1;
        for(int r = 0; r < arr2D.length; r++){
            for(int c = 0; c < arr2D[r].length; c++){
                arr2D[r][c] = counter++; //put the counter in array and then increment counter AFTER
            }
        }


        for(int r = 0; r < arr2D.length; r++){
            for(int c = 0; c < arr2D[r].length; c++){
                System.out.print(arr2D[r][c] + " ");
            }
            System.out.println();
        }
    }
}
