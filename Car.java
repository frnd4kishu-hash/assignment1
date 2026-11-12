import java.awt.*;

public abstract class Car {
    //Fields
    public Color color;
    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public String modelName; // The car model name


    //Methods
    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public String getModelName() {
        return modelName;
    }

    public abstract double speedFactor();

}
