package pdt.sandbox;

public class MyFirstProgram {
    public static void main(String[] args) {
        Point p1 = new Point(1,2);
        Point p2 = new Point (5,4);
       // System.out.println("d = " );
        double d;
        d = p1.distance(p2);
        System.out.println("d = "+ d);
        }
}
