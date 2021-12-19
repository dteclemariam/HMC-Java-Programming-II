package application;

public class Program {

    public static void main(String[] args) {
        // you can test your classes here:

        Sensor NY = new TemperatureSensor();
        Sensor MIA = new TemperatureSensor();
        Sensor TXT = new TemperatureSensor();

        AverageSensor narniaRegion = new AverageSensor();
        narniaRegion.addSensor(NY);
        narniaRegion.addSensor(MIA);
        narniaRegion.addSensor(TXT);

        narniaRegion.setOn();
        System.out.println("temperature in Narnia region " + narniaRegion.read() + " degrees Celsius");
        System.out.println("temperature in Narnia region " + narniaRegion.read() + " degrees Celsius");
        System.out.println("temperature in Narnia region " + narniaRegion.read() + " degrees Celsius");

        System.out.println("readings: " + narniaRegion.readings());
    }

}
