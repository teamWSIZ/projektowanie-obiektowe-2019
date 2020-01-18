package com.example.prototype;

public abstract class Car implements Cloneable{
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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

