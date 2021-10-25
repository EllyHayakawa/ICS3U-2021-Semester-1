package week8;

public class Die {
    //Attributes of a die (will be private)
        //private can only be accessed inside the class.
        //other classes cannot access private attributes/methods/constructors directly.
    private int topSide;
    private int numSides;


    //Constructor
    /**
     * Default/No-Argument constructor
     * If you do not create a constructor, then Java creates a Default/No-Argument constructor for you that does nothing (stay tuned for Unt9)
     * It happens at compilation (you will not see it but it exists)
     */
    public Die(){
        numSides = 6;
        roll();
    }

    // this refers to THIS specific instance of the Die
    //The Die that we are creating/the Die that called the method
    /**
     * If we have the following:
     * Die die1 = new DIe();
     * die1.roll();   //this (inside the class) would be die1
     * @param numSides
     */
    public Die(int numSides){
        this.numSides = numSides; //refers to 'this' particular die
        roll();
    }

    public void roll(){
        topSide = (int)(Math.random()*numSides) + 1;
        //this.topSide = (int)(Math.random()*numSides) + 1; //both the same
    }

    public int getTopSide() {
        return topSide;
    }

    public String toString(){
        return "" + topSide;
    }

    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(obj instanceof Die){ //checks to see if obj is an instanceof Die
            return this.topSide == ((Die)obj).topSide;
        }else{
            return false;
        }
    }
    
}