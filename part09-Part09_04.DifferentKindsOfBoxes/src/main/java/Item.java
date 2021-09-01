
public class Item {

    private String name;
    private int weight;

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Item(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object compareObject) {
        if (this == compareObject) {
            return true;
        }
        if (compareObject == null || compareObject.getClass() != this.getClass()) {
            return false;
        }

        Item comparedItem = (Item) compareObject;
        return this.name.equals(((Item) compareObject).name);
    }

    @Override
    public int hashCode(){
        int result = name.hashCode();
        result = 31 * result * name.hashCode();
        return result;
    }
}
