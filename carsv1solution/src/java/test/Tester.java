package test;

import entity.Car;
import facade.Facade;
import java.util.Date;

public class Tester {

    public static void main(String[] args) {
        Facade f = new Facade();
        Date date = new Date();
        Car car = new Car(1995, date, "Ford", "Escort", "Bad car", 1234.23);
        f.addCar(car);
    }
}
