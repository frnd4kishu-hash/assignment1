import java.awt.*;

public abstract class Car implements Movable {
    //Fields
    private Color color;
    private int NrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private String modelName; // The car model name

    private double x;
    private double y;
    private Direction direction = Direction.NORTH; //

    public Car(int nrDoors, double enginePower, String modelName, Color color) { // gets arguments from subclasses
        this.NrDoors = nrDoors;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.color = color;
        stopEngine();
        }


@Override
public void turnRight() {
    switch (direction) {
        case NORTH:
            direction = Direction.EAST;
            break;
        case EAST:
            direction = Direction.SOUTH;
            break;
        case SOUTH:
            direction = Direction.WEST;
            break;
        case WEST:
            direction = Direction.NORTH;
            break;
    }
}

@Override
public void turnLeft() {
    switch (direction) {
        case NORTH:
            direction = Direction.WEST;
            break;
        case EAST:
            direction = Direction.NORTH;
            break;
        case SOUTH:
            direction = Direction.EAST;
            break;
        case WEST:
            direction = Direction.SOUTH;
            break;
    }
}
@Override
public void move() {
    switch (direction) {
        case NORTH:
            y = y + currentSpeed;
            break;
        case EAST:
            x = x + currentSpeed;
            break;
        case SOUTH:
            y = y - currentSpeed;
            break;
        case WEST:
            x = x - currentSpeed;
            break;
    }

}
    //Methods
    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public int getNrDoors() {
        return NrDoors;
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

    public double getX() {return x; }
    public double getY() {return y; }

}
