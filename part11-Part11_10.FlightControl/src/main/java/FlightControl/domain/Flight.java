package FlightControl.domain;

public class Flight {
    private Airplane airplane;
    private Place departureAirport;
    private Place targetAirport;

    public Flight(Airplane airplane, Place departureAirport, Place targetAirport){
        this.airplane = airplane;
        this.departureAirport = departureAirport;
        this.targetAirport = targetAirport;
    }

    public Airplane getAirplane() {
        return this.airplane;
    }

    public Place getDepartureAirport(){
        return this.departureAirport;
    }

    public Place getTargetAirport() {
        return targetAirport;
    }

    public String toString(){
        return this.airplane + " (" + this.departureAirport + "-" + this.targetAirport + ")";
    }
}
