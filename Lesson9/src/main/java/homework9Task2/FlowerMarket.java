package homework9Task2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString
@AllArgsConstructor

public class FlowerMarket implements FlowerMarketOptions {
    private final List<Bouquet> soldBouquets = new ArrayList<>();

    public Bouquet getBouquet(String... flowers) {
        Flower[] flower = new Flower[flowers.length];
        for (int i = 0; i < flowers.length; i++) {
            String flowerType = flowers[i];
            FlowerType type = findPriceByFlowerName(flowerType);
            if (type != null) {
//                flowers[i] = new Flower(type.getName(), type.getPrice());//у меня все равно выдает ошибку, сделал
                //конструктор и все как надо передал, продебажил пишет, что
                // required: homework9Task2.FlowerType
                //  found:    int,java.lang.String(хотя я сделал FlowerType)
                //  reason: actual and formal argument lists differ in length
            }
        }
        Bouquet bouquet = new Bouquet(flower);
        soldBouquets.add(bouquet);
        return bouquet;
    }

    private FlowerType findPriceByFlowerName(String name) {
        for (FlowerType flowerType : FlowerType.values()) {
            if (flowerType.getName().equalsIgnoreCase(name)) {
                return flowerType;
            }
        }
        return null;
    }

    public int getCountSoldFlowers() {
        int count = 0;
        for (Bouquet soldBouquet : soldBouquets) {
            count += soldBouquet.getFlowers().length;
        }
        return count;
    }

    @Override
    public String info() {
        StringBuilder result = new StringBuilder();
        for (Bouquet soldBouquet : soldBouquets) {
            result.append(soldBouquet.toString());
        }
        return result.toString();
    }

    @Override
    public int getPriceInDay() {
        int price = 0;
        for (Bouquet soldBouquet : soldBouquets) {
            price += soldBouquet.getPricePerBouquet();
        }
        return price;
    }
}

