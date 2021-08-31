import java.util.ArrayList;

public class ChangeHistory {

    private ArrayList<Double> history = new ArrayList<>();

    public ChangeHistory(){}

    public void add(double status){
        history.add(status);
    }

    public void clear(){
        history.clear();
    }

    public double maxValue(){
        double maxValue = history.get(0);
        for (double value : history) {
            maxValue = maxValue > value? maxValue : value;
        }
        return maxValue;
    }

    public double minValue(){
        double minValue = history.get(0);
        for (double value : history) {
            minValue = minValue < value? minValue : value;
        }
        return minValue;
    }

    public double average(){
        double sum = 0.0;
        int count = history.size();
        for (double value : history) {
            sum += value;
        }
        return (1.0 * sum)/count;
    }

    public String toString(){
        return history.toString();
    }
}
