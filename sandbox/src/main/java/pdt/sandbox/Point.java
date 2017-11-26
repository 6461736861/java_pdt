package pdt.sandbox;

import java.util.Scanner;

import static pdt.sandbox.MyFirstProgram.distance;
import static pdt.sandbox.MyFirstProgram.showValues;

public class Point {
    public double p1;
    public double p2;
    int x1;
    int x2;
    int y1;
    int y2;

    Point() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type x1, x2, y1, y2 value for calculation...");
        this.x1 = sc.nextInt();
        this.x2 = sc.nextInt();
        this.y1 = sc.nextInt();
        this.y2 = sc.nextInt();

    }


    public static void main(String[] args) {
        showValues();
        distance();
    }
}

