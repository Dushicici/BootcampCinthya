package examples;

import org.testng.annotations.Test;

/**
 * Created by Cinthya on 20-7-2017.
 */
public class conditionExercises {

    public void bootcampAgeChecker(int age) {
        if (age >= 65) {
            System.out.println("Deelnemer niet toegelaten, check bij de manager");
        }
        else if (age > 21) {
            System.out.println("Deelnemer toegelaten");
        }
        else
            {
            System.out.println("te jong");
        }
    }

        @Test
        public void testMember(){
            bootcampAgeChecker(19);
            bootcampAgeChecker(20);
            bootcampAgeChecker(21);
            bootcampAgeChecker(65);
        }


}
