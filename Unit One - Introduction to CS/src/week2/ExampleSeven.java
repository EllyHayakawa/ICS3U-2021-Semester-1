package week2;

/**
 * Compound Assignment Operators
 */
public class ExampleSeven {
    public static void main(String[] args) {
        int x = 1;

        //x = x + 7; // x is assigned x + 7 (add 7 to x and assign back to x)
        x += 7; //8
        x -= 3; //5
        x *= 2; //10
        x /=3; //3
        x %= 4; //3

        x++;
        ++x;
        x--;
        --x;

        //where x = 3
        int y = 2 * x++; // (y = 2*x), then increment x (x = 4)
        int z = 2 * ++x; // y = 2*(x+1)
        
        y+=2;
        x+=3;

    }
}
