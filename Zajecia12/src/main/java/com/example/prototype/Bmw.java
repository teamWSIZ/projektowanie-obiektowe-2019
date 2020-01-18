package com.example.prototype;

public class Bmw extends Car{
    private String engine;
    private String wheels;
    private String power;
    private String body;

    Bmw(String engine, String wheels, String power, String body){
        this.engine = engine;
        this.wheels = wheels;
        this.power = power;
        this.body = body;
    }

    @Override
    public String engine() {
        return engine;
    }

    @Override
    public String wheels() {
        return wheels;
    }

    @Override
    public String power() {
        return power;
    }

    @Override
    public String body() {
        return body;
    }

    @Override
    public String brand() {
        return "BMW";
    }
}
