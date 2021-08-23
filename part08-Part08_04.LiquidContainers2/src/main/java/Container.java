public class Container {
    private int value = 0;
    private int max = 100;
    private int min = 0;

    public Container(){}

    public int contains(){
        return value;
    }

    public void add(int amount){
        if (amount <= 0){
            return;
        }

        value += amount;

        if (value > max){
            value = max;
        }
    }

    public void remove(int amount){
        if (amount <= 0){
            return;
        }

        value -= amount;

        if (value < 0){
            value = min;
        }
    }

    @Override
    public String toString(){
        return value + "/100";
    }
}
