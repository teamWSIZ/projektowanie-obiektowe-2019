package com.example.prototype;

class CarFactory{
    static Car prototype;
    static Car timedPrototype;

    static long timeout;

    static void setPrototype(Car prototype){
        CarFactory.prototype = prototype;
    }

    static void setPrototypeForTime(Car prototype, long timeSeconds){
        CarFactory.timedPrototype  = prototype;
        CarFactory.timeout = System.currentTimeMillis()+timeSeconds*1000;
    }

    static Car createCar(String brand,String engine, String wheels, String power, String body){
        if(brand.equalsIgnoreCase("bmw"))
            return new Bmw(engine,wheels,power,body);

        if(brand.equalsIgnoreCase("OpelInsignia"))
            return new OpelInsignia(engine,wheels,power,body);

        return null;
    }

    static Object getCar() throws CloneNotSupportedException {
        if(timeout>System.currentTimeMillis())
            return timedPrototype.clone();
        else
            return prototype.clone();
    }

    static Car createRandomCar(){
        return null;
    }
}
