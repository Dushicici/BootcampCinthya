package examples;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

/**
 * Created by Cinthya on 19-7-2017.
 */
public class Controles {

    @Test
    public void assertStringContains() {
        String text = "Ik zit hier bij de summer automation bootcamp";

        Assertions.assertThat(text).as("Ik vind het leuk").contains("programmeren");
    }

    @Test
    public void assertIntegerGreaterThan() {
        int testInt = 15;

        Assertions.assertThat(testInt).as("Participanten").isGreaterThan(15);
    }
}