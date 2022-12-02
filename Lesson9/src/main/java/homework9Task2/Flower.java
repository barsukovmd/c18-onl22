package homework9Task2;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
@Getter

public class Flower {
    private String name;
    private FlowerType flowerType;

    public Flower(FlowerType flowerType) {
        this.name = getFlowerType().name();
        this.flowerType = flowerType;
    }
}