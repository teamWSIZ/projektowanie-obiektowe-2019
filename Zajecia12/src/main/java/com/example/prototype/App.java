/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.example.prototype;

public class App {

    public static void main(String[] args) {
        Bmw bmw0 = new Bmw("2.5","19","450hp","Coupe");
        bmw0.print();

        Bmw bmw1 = (Bmw)bmw0.clone();
        bmw1.print();
    }
}
