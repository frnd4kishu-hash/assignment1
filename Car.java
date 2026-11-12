import java.awt.*;

public abstract class Car implements Movable {
    //Fields
    private Color color;
    private int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private String modelName; // The car model name

    private double x;
    private double y;
    private Direction direction = Direction.NORTH;

    public Car(int nrDoors, double enginePower, String modelName, Color color){ // gets arguments from subclasses
        this.nrDoors=nrDoors;
        this.enginePower=enginePower;
        this.modelName=modelName;
        this.color=color;
        stopEngine();
    }

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
    
    public String getModelName() {
        return modelName;
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
    private void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    private void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    protected abstract double speedFactor();  // Protected because car declares it, but needs subclasses to see it to provide values
                                             // No outside code need this, only subclasses to be able to override
    // TODO fix this method according to lab pm
    public void gas(double amount) {
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount) {
        decrementSpeed(amount);
    }
}
