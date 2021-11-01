package week9;

/**
 * We are inheriting everything from the Rectangle class
 */
public class Box extends Rectangle{

    /**
     * If you do not write an explicit (your own) constructor then Java supplies this one for you.
     * It does NOTHING except call your parents no-argument constructor.
     
    public Box(){
        //super is the parent class (in this case Rectangle)
        super();
    }
    */

    private double height = 0;

    public Box(double l, double w, double h){
        //length = l; // child classes do not have direct access to their parents private attributes and methods
        //width = w;
        super(l, w); // if you are oging to call your parent's constructor it has to be the first ghing in your constructor
        height = h;
        //super(l, w); //this causes an error because it is not the first thing in the constructor
    }

    public Box(double side){
        super(side); //calls the constructor that has 1 parameter side and creates a square
        height = side;
    }

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj instanceof Box){
            Box b = (Box)obj;
            return this.height == b.height && this.getLength() == b.getLength() && this.getWidth() == b.getWidth();
        }else{
            return false;
        }
    }

    public double getArea(){
        return (2*super.getArea()) + getLength() * height * 2 + getWidth() * height * 2;
    }

    public double getVolume(){
        return super.getArea()*height;
    }

    public String toString(){
        return "Box with length of " + getLength() + ", width of " + getWidth() + " and height of " + height;
    }

    /**
     * really just gets all the edges
     
    public double getPerimeter(){
        return super.getArea() * 2 + 4 * height;
    }
    */
}
