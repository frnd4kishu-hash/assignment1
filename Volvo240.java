import java.awt.*;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;    // Just like in Saab95, this is only used within this subclass, no need to be public

    public Volvo240() {
        super(4, 100, "Volvo240", Color.black);
    }

    @Override
    protected double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }
}
