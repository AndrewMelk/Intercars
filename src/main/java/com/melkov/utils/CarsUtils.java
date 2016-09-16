package com.melkov.utils;


import com.melkov.domain.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 04.08.16.
 */
public class CarsUtils {

    private static List<Car> list = new ArrayList<Car>();

    public static List<Car> carList(){

        list.add(new Car(1,"BMW","320",10,2));
        list.add(new Car(1,"Audi","A6",15,2));
        list.add(new Car(1,"Honda","Civic",8,1.8));


        return  list;
    }

    public static void addCar(Car car){

        list.add(car);

    }

}
