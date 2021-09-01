import java.util.ArrayList;

public class BoxWithMaxWeight extends Box{

    private int capacity;
    private ArrayList<Item> itemsInBox;

    public BoxWithMaxWeight(int capacity){
        this.capacity = capacity;
        itemsInBox = new ArrayList<>();
    }

    public int currentWeight(){
        int currentWeight = 0;
        for (Item item : itemsInBox) {
            currentWeight += item.getWeight();
        }
        return currentWeight;
    }

    @Override
    public void add(Item item) {
        if (currentWeight() + item.getWeight() <= this.capacity){
            itemsInBox.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return itemsInBox.contains(item);
    }
}
