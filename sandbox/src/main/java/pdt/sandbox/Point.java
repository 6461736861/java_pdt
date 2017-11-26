package pdt.sandbox;

import java.util.Scanner;


public class Point {
    int x1;
    int x2;
    int y1;
    int y2;

  public  Point() {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;

    }
     void setPoint(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Type x1, x2, y1, y2 value for calculation...");
        x1 = sc.nextInt();
        x2 = sc.nextInt();
        y1 = sc.nextInt();
        y2 = sc.nextInt();
    }

    void printPoint(){
        System.out.println("x1 = " + x1);
        System.out.println("x2 = " + x2);
        System.out.println("y1 = " + y1);
        System.out.println("y2 = " + y2);
    }

     void distanceBetweenPoints(){
        double d;
        //Point p = new Point();
        d =Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
        System.out.println("d = "+ d);
    }

    public static void main(String[] args){

    }
}
