package pdt.sandbox;

import java.util.Scanner;

public class MyFirstProgram {
    static Point p = new Point();

    public static void showValues() {
     //   Point p = new Point();

        System.out.println("x1 = " + p.x1);
        System.out.println("x2 = " + p.x2);
        System.out.println("y1 = " + p.y1);
        System.out.println("y2 = " + p.y2);

    }

    public static void distance() {
        double d;

        d =Math.sqrt(Math.pow(p.x2-p.x1, 2) + Math.pow(p.y2-p.y1, 2));
         System.out.println("d = "+ d);
       // return d;
    }

    public static void main(String[] args) {

    }


}