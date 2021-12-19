package application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AverageSensor implements Sensor{
    private List<Sensor> sensors;
    private List<Integer> readings;

    public AverageSensor (){
        sensors = new ArrayList<>();
        readings = new ArrayList<>();
    }

    public void addSensor(Sensor toAdd){
        sensors.add(toAdd);
    }

    @Override
    public boolean isOn() {
        boolean isOn = true;
        Iterator<Sensor> iterator = sensors.iterator();

        while (iterator.hasNext()){
            if (!iterator.next().isOn()){
                isOn = false;
            }
        }

        // Started using for each but wanted to try it using iterator above for practice
//        for (Sensor sensor : sensors) {
//            if (!sensor.isOn())
//                isOn = false;
//        }

        return isOn;
    }

    @Override
    public void setOn() {
        sensors.stream()
                .forEach(sensor -> sensor.setOn());
    }

    @Override
    public void setOff() {
        sensors.stream()
                .forEach(sensor -> sensor.setOff());
    }

    @Override
    public int read(){
        if (!isOn() || sensors.isEmpty()) throw new IllegalStateException();

        double avg = sensors.stream()
                .mapToInt(sensors -> Integer.valueOf(sensors.read()))
                .average()
                .getAsDouble();

        readings.add((int) avg);
        int avgAsInt = (int) avg;
        return avgAsInt;
    }

    public List<Integer> readings(){
        return readings;
    }
}
