package models;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Car2 implements CarCharacteristicImpl {
    public void getDistance() {
        System.out.println("Car 2 200km");
    }
}