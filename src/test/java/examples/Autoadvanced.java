package examples;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Created by Cinthya on 21-7-2017.
 */
public class Autoadvanced {

    public String brand;

    public Autoadvanced (String brand, int Force, int EngineRPMs) {
        this.brand = brand;
        System.out.println("Car is ready to drive");
        System.out.println("Brand of the car is "+ brand);
        calculateTorque(Force, EngineRPMs);
    }

    public void printBrand(){
        System.out.println(brand);
    }

    public void calculateTorque (int Force, int EngineRPMs) {
        int torque = (Force * 5252 / EngineRPMs);
        System.out.println("The torque of the car is " + torque);
    }
}
