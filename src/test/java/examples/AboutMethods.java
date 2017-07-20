package examples;

import org.testng.annotations.Test;

/**
 * Created by Cinthya on 19-7-2017.
 */
public class AboutMethods {


    private int Multiply (){
        int myGetal1 = 2;
        int myGetal2 = 4;
        int multy = myGetal1 * myGetal2;

        return multy;

    }
    @Test
    public void printProduct(){
        System.out.println(Multiply());
    }
}
