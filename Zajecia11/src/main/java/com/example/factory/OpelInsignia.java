package com.example.factory;

public class OpelInsignia extends Car{
    private String engine;
    private String wheels;
    private String power;
    private String body;

    OpelInsignia(String engine, String wheels, String power, String body){
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
        return "Opel Insignia";
    }
}
