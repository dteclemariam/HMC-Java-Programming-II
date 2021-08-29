import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegistry {

    private HashMap<LicensePlate, String> registry = new HashMap<>();

    public boolean add(LicensePlate licensePlate, String owner){
        if (!registry.containsKey(licensePlate)){
            registry.put(licensePlate, owner);
            return true;
        }
        return false;
    }

    public String get(LicensePlate licensePlate){
        //From Oracle docs: returns null if this map contains no mapping for the key.
        return registry.get(licensePlate);
    }

    public boolean remove(LicensePlate licensePlate){
        if (!registry.containsKey(licensePlate)){
            return false;
        }

        registry.remove(licensePlate);
        return true;
    }

    public void printLicensePlates(){
        for (LicensePlate lp : registry.keySet()) {
            System.out.println(lp.toString());
        }
    }

    public void printOwners(){
        ArrayList<String> owners = new ArrayList<>();
        for (String owner : registry.values()) {
            if (!owners.contains(owner)){
                owners.add(owner);
                System.out.println(owner);
            }
        }
    }
}
