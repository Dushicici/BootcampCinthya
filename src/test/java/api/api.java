package api;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

/**
 * Created by Cinthya on 28-7-2017.
 */
public class api {

    String season;
    String driver;

    @Test
    public void getResultsMax () {
        given().
                when().get("http://ergast.com/api/f1/2016/drivers/max_verstappen/results.json").
                then().statusCode(200);
    }
    @Test
    public void assertTextMax (){
        given().
                when().get("http://ergast.com/api/f1/2016/drivers/max_verstappen/results.json").
                then().assertThat().body("MRData.RaceTable.driverId", containsString("verstappen"));
    }

    @Test
    public void testUrlParam(){
        season = "2016";
        driver = "max_verstappen";


        given().pathParam("season", season).pathParam("driverId", driver).
                when().get("http://ergast.com/api/f1/{season}/drivers/{driverId}/results.json").
                then().statusCode(200);
    }
}
