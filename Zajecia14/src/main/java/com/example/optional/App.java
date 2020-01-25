/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.example.optional;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class App {
    static ArrayList<Double> mTab = new ArrayList<>();

    public static void main(String[] args) {
        //oblicz(null);

        mTab.add(1.0);
        mTab.add(2.0);


        try {
            System.out.println("Średnia: "+average(mTab));
        } catch (Exception e) {
            e.printStackTrace();
        }


        oblicz1(null);
    }

    static double average(ArrayList<Double> tablica) throws Exception{
        double srednia = 0;

        if(tablica!=null && tablica.size()!=0){

            for(Double value : tablica)
                srednia+=value;

        }else throw new Exception("Nieprawidłowe dane");

        return srednia/tablica.size();
    }


}
