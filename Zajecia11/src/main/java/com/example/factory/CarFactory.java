package com.example.factory;

class CarFactory{
    static Car createCar(String brand,String engine, String wheels, String power, String body){
        if(brand.equalsIgnoreCase("bmw"))
            return new Bmw(engine,wheels,power,body);

        if(brand.equalsIgnoreCase("OpelInsignia"))
            return new OpelInsignia(engine,wheels,power,body);

        return null;
    }

    static Car createRandomCar(){
        return null;
    }
}
