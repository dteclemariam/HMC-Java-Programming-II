import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<String, Item> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    public void add(String product, int price) {
        this.items.putIfAbsent(product, new Item(product, 0, price));
        items.get(product).increaseQuantity();
    }

    public int price() {
        int sum = 0;
        for (Item item : items.values()) {
            sum += item.price();
        }
        return sum;
    }

    public void print() {
        for (Item item : items.values()) {
            System.out.println(item.toString());
        }
    }
}
