package day0201;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01 {
    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
    //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

    WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com");
        driver.findElement(By.xpath("//*[text()='Kabul ediyorum']")).click();



    }
    @Test
    public void titleTest() {
        String actualTitle =driver.getTitle();
        String expectedTitle = "YouTube";
        Assert.assertEquals(actualTitle, expectedTitle, "Title Test basarisiz");




    }
    @Test
    public void imageTest() {
        driver.findElement(By.id("logo-icon")).isDisplayed();



    }

    @Test
    public void searchBoxTest() {
        driver.findElement(By.xpath("//input[@id='search']")).isEnabled();



    }
    @Test
    public void wrongTitleTest() {
    String actualTitle = driver.getTitle();
    String beklenmeyenTitle="youtube";

    Assert.assertFalse(Boolean.parseBoolean(actualTitle), beklenmeyenTitle);


    }



}
