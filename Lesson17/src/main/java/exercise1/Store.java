package exercise1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@SuperBuilder
@Getter
@ToString
@AllArgsConstructor
//     * Создать класс Магазин, поля:
//     * • Список товаров (изначально пустой)
//     * методы:

//     * • добавить товар(принимает объект товара и добавляет его в список
//     * товаров). При попытке добавить товар с id уже существующем в списке,
//     * вставка производится не должна

//     * • получить все товары(метод ВОЗВРАЩАЕТ список всех товаров в
//     * магазине)
//     * • удалить товар (метод принимает id товара и удаляет из списка товар с
//     * соответствующим id)
//     * • редактировать товар(принимает объект товара и редактирует им список
//     * товаров)
//     * Обратите внимание что id товара и индекс товара в списке — это разные вещи, не перепутайте.
//     * Id товара — это поле вашего объекта, вы при его создании его задаете. А индекс товара в списке товаров, это по сути его порядковый номер в списке(начинается с 0).
//
public class Store {
    private Product product;
    private ArrayList<Product> productType;

    public boolean getProductType(Product productType) {
        List<Product> type = new ArrayList<>();
        if (product.getId() != productType.getId()) {
            return type.add(productType);
        } else {
            return false;
        }
    }

    public List<Product> allProducts() {
        return getProductType();
    }

    public String deleteProductWithId(int id) {
        if (product.getId() == id) {
            for (Product removeProduct : productType) {
                return removeProduct.getName();
            }
        }
        return null;
    }
}