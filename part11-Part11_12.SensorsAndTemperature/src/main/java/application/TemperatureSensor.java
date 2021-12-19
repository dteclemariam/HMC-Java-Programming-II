package application;

import java.util.Random;

public class TemperatureSensor implements Sensor{
    private boolean isOn;

    public TemperatureSensor (){
        isOn = false;
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public void setOn() {
        isOn = true;

    }

    @Override
    public void setOff() {
        isOn = false;

    }

    @Override
    public int read() {
        if (!isOn) throw new IllegalStateException();
        return new Random().nextInt(61) - 30;

    }
}
