package day0128;

import org.testng.annotations.Test;

public class C01_Notations {

    @Test
    public void amazonTest(){
        System.out.println("Amazon");

    }
    @Test(priority = -9)
    public void youtubeTest(){
        System.out.println("Youtube");


    }
    @Test(priority = 1)
    public void bestBuyableTest(){
        System.out.println("Bestbuy");

    }


}
