/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.example.factory;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();

        for(int i=0;i<100;i++){
            Car car;
            switch((int)(Math.random()*2+1)){
                case 1:
                    car = CarFactory.createCar("BMW","2.5","19","450hp","Coupe");
                    cars.add(car);
                    break;
                case 2:
                    car = CarFactory.createCar("OpelInsignia","2.0","19","250hp","Coupe");
                    cars.add(car);
                    break;
            }
        }

        for(Car car : cars)
            car.print();
    }
}

