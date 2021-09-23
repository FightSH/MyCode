package org.example.optional;

import org.example.optional.DO.Car;
import org.example.optional.DO.Insurance;
import org.example.optional.DO.Person;

import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {

    }


    public static String getCarInsuranceName(Person person) {
        return person.getCar().getInsurance().getName();
    }

    public static Insurance findCheapestInsurance(Person person, Car car) {
        Insurance cheapestInsurance = new Insurance();
        return cheapestInsurance;
    }

    public static Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person, Optional<Car> car) {
        // 如果flatMap
        return person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));
    }


}
