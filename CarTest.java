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

    // test 1 for gas between interval [0,1]
    private static void GastestForInvalidValues() {   //checks if gas() only accepts values inside the range [0,1]
        Volvo240 car = new Volvo240();
        boolean tooLowRejected = false;    //basically, the lowest value is not rejected yet because we don´t have an "amount" valeu for gas() or brake() yet
        boolean tooHighRejected = false;

        try {
            car.gas(1.5);
        } catch  (IllegalArgumentException error)  {
            tooHighRejected = true;  //value 1.5 is out of range, so "rejection" is true now
        }

        try {
            car.gas(-0.5);
        } catch  (IllegalArgumentException error)  {
            tooLowRejected = true;
        }

        reportResult("gas() rejects values outside greater than 1", tooHighRejected); //"rejection" is true, so prints success

        reportResult("gas() rejects values outside less than 0", tooLowRejected);
}
// test 2 for brakes between the interval [0,1]
    private static void BraketestInvalidValues() {
        Volvo240 car = new Volvo240();
        boolean tooHighRejected = false;
        boolean tooLowRejected = false;

        try{
            car.brake(1.5);
        } catch (IllegalArgumentException error) {
            tooHighRejected = true;
        }
        try{
            car.brake(-0.5);
        } catch (IllegalArgumentException error) {
            tooLowRejected = true;
        }
        reportResult("brake() rejects values greater than 1" , tooHighRejected);
        reportResult("brake() rejects values less than 0", tooLowRejected);
    }
    //Test 3 for requirement three
    private static void testSpeedNotaAboveEnginePower() {
        Saab95 car = new Saab95();
        car.setTurboOn();
        for (int i = 0; i<1000; i++) {
            car.gas(1);
        }
        boolean result = car.getCurrentSpeed() <=car.getEnginePower();
        reportResult("Speed never goes above enginePower", result);
    }
    //
    private static void testSpeedNotBelowZero() {
        Volvo240 car=new Volvo240();
        car.gas(0.5);
        for (int i =0; i<1000;i++) {
            car.brake(1);
        }
        boolean result = car.getCurrentSpeed()>= 0;
        reportResult("Speed never goes below 0", result);
    }

    private static void testGasDoesNotDecreaseSpeed() {
        Volvo240 car = new Volvo240();
        car.gas(0.5);
        double speedBefore = car.getCurrentSpeed();
        car.gas(0.5);
        boolean result = car.getCurrentSpeed() >= speedBefore;
        reportResult("gas() does not decrease speed", result);
    }

    private static void testBrakeDoesNotIncreaseSpeed(){
        Volvo240 car = new Volvo240();
        car.gas(0.5);
        double speedBefore = car.getCurrentSpeed();
        car.brake(0);
        boolean result = car.getCurrentSpeed()<= speedBefore;
        reportResult("brake() does not increase speed", result);
    }



    public static void main() {   //String[] args
        testTurbo();
        testStartEngine();
        testStopEngine();
        testVolvoDoors();
        testSaabDoors();
        testBrake();

        //Task 4
        GastestForInvalidValues();
        BraketestInvalidValues();
        testSpeedNotaAboveEnginePower();
        testSpeedNotBelowZero();
        testGasDoesNotDecreaseSpeed();
        testBrakeDoesNotIncreaseSpeed();


    }
}



