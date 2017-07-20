package examples;

import org.testng.annotations.Test;

/**
 * Created by Cinthya on 19-7-2017.
 */
public class AboutMethods2 {

    @Test
    public void  printProduct(){
        System.out.println(multiply(2,5));

    }
    private int multiply(int myGetal1, int myGetal2){
        return myGetal1 * myGetal2;
    }
}
