package homework9Task2;

import lombok.Getter;
import lombok.ToString;

@ToString


@Getter
public enum FlowerType {
    ROSE(15), LILY(7), ASTER(5), GERBERA(5), TULIP(8), CARNATION(11);
    private int cost;

    FlowerType(int price) {
        cost = price;
    }
}
