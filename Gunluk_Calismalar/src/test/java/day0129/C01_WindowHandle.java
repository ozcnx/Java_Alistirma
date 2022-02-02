package day0129;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseTest;

import java.util.Map;
import java.util.Set;

public class C01_WindowHandle extends BaseTest {

    //Amazon.com a gidin
    @Test
    public void amazonTest(){

        driver.get("https://www.amazon.com");
       // amazonun handle degerini alalim
        System.out.println("Amazon Handle :"+ driver.getWindowHandle()); //CDwindow-912E0F3348F21F6377B75D4E1069DDF7
        String amazonHandle=driver.getWindowHandle();

        //Bestbuy sitesine gidelim ve handle degerini alalim.

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        System.out.println("BestBuy Handle :"+driver.getWindowHandle());
        String bestbuyHandle=driver.getWindowHandle();

        //her iki sitenin handle degerlerini bir Set'e atalim
        Set<String> handles=driver.getWindowHandles();

        //yeni tab acarak facebook a gidelim

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.facebook.com");
        //pop up'i gecelim
        driver.findElement(By.xpath("//*[text()='Tüm Çerezlere İzin Ver']")).click();

        //// amazon'un acik oldugu sayfaya gecin ve nutella icin arama yapin

        driver.switchTo().window(amazonHandle);
        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        //// bestbuy acik olan sayfaya gecin ve title'in Best Buy icerdigini test edin

        driver.switchTo().window(bestbuyHandle);
        String actuelBestbuyTitle=driver.getTitle();
        String expectedBestbuyTitle="Best Buy";

        Assert.assertTrue(actuelBestbuyTitle.contains(expectedBestbuyTitle));

        // facebook'un acik oldugu sayfaya gecin
        // ve url'in https://www.facebook.com oldugunu test edin

        handles=driver.getWindowHandles();
       String facebookHandle = "";

        for (String w:handles
             ) {
            if (!w.equals(amazonHandle) || !(w.equals(bestbuyHandle))){
                facebookHandle=w;

            }

        }
        driver.switchTo().window(facebookHandle);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");



    }
}
