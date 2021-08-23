import java.util.ArrayList;

public class TodoList {
    private ArrayList<String> tasks = new ArrayList<>();

    public TodoList(){}

    public void add(String task){
        tasks.add(task);
    }

    public void print(){
        int taskNumber = 1;
        for (String task : tasks) {
            System.out.println(taskNumber + ": " +task);
            taskNumber++;
        }
    }

    public void remove(int numberToRemove){
        tasks.remove(numberToRemove - 1);
    }
}
