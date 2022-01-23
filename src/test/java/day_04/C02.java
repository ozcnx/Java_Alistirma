package day_04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {

    //1) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
    //		○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    //		○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //		○ logoTest => BestBuy logosunun görüntülendigini test edin
    //		○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

  static WebDriver driver;
    @BeforeClass
    static public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.bestbuy.com/");

    }
    @Test
    public void urlTesti() {
        //		○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.bestbuy.com/";
        Assert.assertEquals("URL esit degil",actualUrl,expectedUrl);

    }
    @Test
    public void titleTest() {
        //		○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin

        String actualTitle = driver.getTitle();
        String expectedTitle ="Rest";
        Assert.assertFalse(actualTitle.equals(expectedTitle));

    }
    @Test
    public void logoTest() {

        //		○ logoTest => BestBuy logosunun görüntülendigini test edin

            WebElement logoElementi = driver.findElement(By.xpath("//*[@alt='Best Buy Logo']"));
            Assert.assertTrue(logoElementi.isDisplayed());
    }
    @Test
    public void linkTest() {
        //		○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement linkElementi = driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(linkElementi.isDisplayed());

    }


    @AfterClass
    static public void teardown() {
        driver.close();
    }

}
