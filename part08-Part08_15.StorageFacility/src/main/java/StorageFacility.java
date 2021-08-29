import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {
    private HashMap<String, ArrayList<String>> storage;

    public StorageFacility(){
        storage = new HashMap<>();
    }

    public void add(String unit, String item){
        storage.putIfAbsent(unit, new ArrayList<>());
        storage.get(unit).add(item);
    }

    public ArrayList<String> contents(String storageUnit){
        if (!storage.containsKey(storageUnit)){
            return new ArrayList<>();
        }

        return storage.get(storageUnit);
    }

    public void remove(String storageUnit, String item){
        ArrayList<String> currentStorageUnitItems = storage.get(storageUnit);
        currentStorageUnitItems.remove(item);
        if (currentStorageUnitItems.isEmpty()){
            storage.remove(storageUnit);
        }

    }

    public ArrayList<String> storageUnits(){
        ArrayList<String> storageUnits = new ArrayList<>();
        for (String unit : storage.keySet()) {
            if (!storage.get(unit).isEmpty()){
                storageUnits.add(unit);
            }
        }
        return storageUnits;
    }

}
