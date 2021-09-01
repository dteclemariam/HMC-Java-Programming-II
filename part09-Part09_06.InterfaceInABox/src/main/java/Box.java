import java.util.ArrayList;

public class Box implements Packable{
    private double capacity;
    private ArrayList<Packable> content;

    public Box(double capacity){
        this.capacity = capacity;
        this.content = new ArrayList<>();
    }

    public void add(Packable newItem){
        if (weight() + newItem.weight() <= capacity){
            content.add(newItem);
        }
    }

    @Override
    public double weight() {
        double totalWeight = 0.0;
        for (Packable item : content) {
            totalWeight += item.weight();
        }
        return totalWeight;
    }

    public String toString(){
        return "Box: " + content.size() + " items, total weight " + weight() + " kg";
    }
}
