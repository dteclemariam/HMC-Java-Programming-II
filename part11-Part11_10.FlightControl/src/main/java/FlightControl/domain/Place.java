package FlightControl.domain;

public class Place {
    private String ID;

    public Place(String ID){
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        return ID;
    }
}
