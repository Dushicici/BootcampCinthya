package examples;

import org.testng.annotations.Test;

/**
 * Created by Cinthya on 21-7-2017.
 */
public class CarGame {

    @Test
    public void startGame() {

        Auto auto = new Auto();
        auto.setColor("Rood");
        auto.setBrand("Peugot");
        auto.setDoors("4");
        auto.setMotorType("V8, 5.2 litre");
        auto.calculateTorque(20, 30);


        Auto autoTwo = new Auto();
        autoTwo.setColor("Pimple Pruple");
        auto.setBrand("Opel");
        auto.setDoors("2");
        auto.setMotorType("V6, 8.2 litre");
        auto.calculateTorque(3, 10);
    }
       @Test
        public void startGameTwo(){
            Autoadvanced autoadvanced = new Autoadvanced("Toyota", 20, 20);
            autoadvanced.printBrand();
    }
}
