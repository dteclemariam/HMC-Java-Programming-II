import java.util.ArrayList;
import java.util.List;

public class Pipe <T>{

    private List<T> list;

    public Pipe(){
        list = new ArrayList<>();
    }

    public void putIntoPipe(T value){
        list.add(value);
    }

    public T takeFromPipe(){
        T reply = isInPipe() == true? list.get(0) : null;
        if (reply != null) list.remove(0);

        return reply;
    }

    public boolean isInPipe(){
        return list.isEmpty() != true;
    }
}
