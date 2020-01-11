package com.example.factory;

public abstract class Car{
    public abstract String engine();
    public abstract String wheels();
    public abstract String power();
    public abstract String body();

    public abstract String brand();

    @Override
    public String toString() {
        return brand()+" : "+"["+engine()+", "+wheels()+", "+power()+", "+body()+"]";
    }

    public void print(){
        System.out.println(toString());
    }
}

