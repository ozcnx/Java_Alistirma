import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BaseTest;

public class C03 extends BaseTest {

    //Yeni bir Class Olusturun : D11_SoftAssert1
    //1. “https://www.hepsiburada.com/” Adresine gidin
    //2. Basliginin “Turkiye’nin En Buyuk Alisveris Sitesi" icerdigini dogrulayin
    //3. search kutusuna araba yazip arattirin
    //4. bulunan sonuc sayisini yazdirin
    //5. sonuc yazisinin "araba" icerdigini dogrulayin
    //6. Sonuc yazisinin “oto” kelimesi icermedigini dogrulayin


    @Test
    public void titleTest (){
        driver.get("https://www.hepsiburada.com/");
        String actualTitle=driver.getTitle();
        String expectedTitle="Turkiye’nin En Buyuk Alisveris Sitesi";
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(actualTitle.contains(expectedTitle));

        driver.findElement(By.xpath("//*[@class='desktopOldAutosuggestTheme-input']")).sendKeys("Araba"+ Keys.ENTER);
        String sonucSayisi=driver.findElement(By.xpath("//*[@class='searchResultSummaryBar-mainText']")).getText();
        sonucSayisi.replaceAll("\\D","");
        System.out.println("Bulunan sonuc sayisi : " +sonucSayisi);

        softAssert.assertTrue(sonucSayisi.contains("araba"),"Sonuc araba icermiyor");

        softAssert.assertFalse(sonucSayisi.contains("oto")," sonuc oto iceriyor");
        softAssert.assertAll();


    }


}
