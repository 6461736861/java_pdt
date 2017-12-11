package pdt.sandbox;

import java.util.Scanner;


public class Point {
    int x;
    int y;

    public Point(int x1, int y1) {
        this.x = x1;
        this.y = y1;
    }

    public double distance(Point p2) {
        return Math.sqrt(Math.pow(p2.x - x, 2) + Math.pow(p2.y - y, 2));
        //  System.out.println("d = " );
    }
}
