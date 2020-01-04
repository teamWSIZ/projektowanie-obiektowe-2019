package com.threads;

public class ShipEquations{
    static double speedX(double x, double borderXmin, double borderXmax){
        double v = 0.1;
        double borderXdistance = borderXmin+x;
        double v1 = v-0.0001*borderXdistance;
        System.out.println("border X distance: "+borderXdistance);
        System.out.println("new Speed: "+v1);
        return v1;
    }
}
