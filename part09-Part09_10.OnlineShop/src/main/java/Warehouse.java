import java.util.*;

public class Warehouse {
    private Map<String, Integer> products;
    private Map<String, Integer> inventory;

    public Warehouse(){
        products = new HashMap<>();
        inventory = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock){
        products.put(product, price);
        inventory.put(product, stock);

    }

    public int price(String product){
        return products.getOrDefault(product, -99);
    }

    public int stock(String product){
        return inventory.getOrDefault(product, 0);
    }

    public boolean take(String product){
        if (inventory.containsKey(product) && stock(product) > 0){
            int stock = inventory.get(product);
            inventory.replace(product, stock - 1);
            return true;
        }
        return false;
    }

    public Set<String> products(){
        Set<String> productsSet = this.products.keySet();
        return productsSet;
    }
}
