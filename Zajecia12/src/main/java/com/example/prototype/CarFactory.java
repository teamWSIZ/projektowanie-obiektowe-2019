package com.example.prototype;

class CarFactory{
    static Car prototype;

    static void setPrototype(Car prototype){
        CarFactory.prototype = prototype;
    }

    static Car createCar(String brand,String engine, String wheels, String power, String body){
        if(brand.equalsIgnoreCase("bmw"))
            return new Bmw(engine,wheels,power,body);

        if(brand.equalsIgnoreCase("OpelInsignia"))
            return new OpelInsignia(engine,wheels,power,body);

        return null;
    }

    static Object getCar() throws CloneNotSupportedException {
        return prototype.clone();
    }

    static Car createRandomCar(){
        return null;
    }
}
