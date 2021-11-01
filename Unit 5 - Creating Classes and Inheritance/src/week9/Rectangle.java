package week9;

public class Rectangle {
    private double length = 0;
    private double width = 0;
    
    public Rectangle(double l, double w){
        length = l;
        width = w;
    }

    public Rectangle(double side){
        length = side;
        width = side;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getArea(){
        return length*width;
    }

    public double getPerimeter(){
        return (length + width)*2;
    }

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj instanceof Rectangle){
            Rectangle r = (Rectangle)obj;
            return this.length == r.length && this.width == r.width;
        }else{
            return false;
        }
    }

    public String toString(){
        return "Rectangle with length of " + length + " and width of " + width;
    }

}
