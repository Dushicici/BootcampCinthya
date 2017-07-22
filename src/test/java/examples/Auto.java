package examples;

public class Auto {

    public void setColor (String carColor){
        System.out.println("The color of the car: "+ carColor);
    }
    public void setBrand(String carBrand) {
        System.out.println("The brand of the car: " + carBrand);
    }
    public void setDoors(String carDoors) {
        System.out.println("The doors of the car: " + carDoors);
    }
    public void setMotorType(String carMotorType) {
        System.out.println("The motortype of the car: " + carMotorType);
    }
    public void calculateTorque (int Force, int EngineRPMs) {
        System.out.println("The torque of the car is " + Force * 5252 / EngineRPMs);
    }

}
