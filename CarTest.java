public class CarTest {
    private static void reportResult(String testName, boolean success) {
        IO.println((success ? "SUCCESS: " : "FAILURE: ") + testName);
    }

    /** Tests whether a Saab95 with turbo enabled
     *  gains more speed than one without.
     */
    private static void testTurbo() {
        Saab95 slowSaab = new Saab95();
        Saab95 fastSaab = new Saab95();
        fastSaab.setTurboOn();
        slowSaab.setTurboOff();
        fastSaab.gas(0.5);
        slowSaab.gas(0.5);
        boolean result = slowSaab.getCurrentSpeed() < fastSaab.getCurrentSpeed();
        reportResult("Turbo yields more speed", result);
    }

    //test engine start: when startEngine() is called, currentspeeed should be 0.1. saab
    // test stop of engine: currentspeed needs to be 0. volvo
    private static void testStartEngine(){
        Saab95 car = new Saab95();
        car.startEngine();
        boolean result = car.getCurrentSpeed() == 0.1;    //checks if the current speed when the engine is start is 0.1
        reportResult("Engine started, it works correctly.",result);
    }
    private static void testStopEngine(){
        Volvo240 carsStop = new Volvo240();
        carsStop.stopEngine();
        boolean result = carsStop.getCurrentSpeed() == 0;    //checks if the current speed when the engine is start is 0
        reportResult("Engine stopped correctly.",result);
    }


    //test for number of doors for volvo and saab cars
    private static void testVolvoDoors() {
        Volvo240 volvoDoors = new Volvo240();
        volvoDoors.getNrDoors();
        boolean result = volvoDoors.getNrDoors()== 4;   //checks if volvo has 2 doors
        reportResult("The car Volvo240 has 4 doors ", result);
    }
    private static void testSaabDoors() {
        Saab95 SaabDoors = new Saab95();
        SaabDoors.getNrDoors();
        boolean result = SaabDoors.getNrDoors() == 2;   //checks if saab has 2 doors
        reportResult("The car Saab95 has 4 doors ", result);

    }

    //test move right or left
    private static void testBrake(){
        Saab95 car = new Saab95();

        car.startEngine();
        car.gas(0.5);   //amount is used in the example we were given for gas in TestTurbo()

        double speedBeforeSaab = car.getCurrentSpeed();
        car.brake(0.5);

        boolean result = car.getCurrentSpeed() < speedBeforeSaab;   //if the current speed is less than the speed before, the car slowed down
        reportResult("Brake works, Saab95 decreases its speed.", result);
    }




    static void main() {   //String[] args
        testTurbo();
        //TODO: add and run more tests

        testStartEngine();
        testStopEngine();
        testVolvoDoors();
        testSaabDoors();
        testBrake();

    }
}

