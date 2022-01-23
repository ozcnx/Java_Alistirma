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

//1) Bir class oluşturun: YoutubeAssertions
//2) https://www.youtube.com adresine gidin
//3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
//    ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
//    ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
//     ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
//    ○ wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin

public class C05_YoutubeAssertion {

    static WebDriver driver;

    @BeforeClass
    static public void setup() {

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com");
        driver.findElement(By.xpath("//*[text()='Kabul ediyorum']")).click();


    }
    @AfterClass
    static public void teardown() throws InterruptedException {
        Thread.sleep(10000);
        driver.close();
    }

    @Test
    public void titleTest(){
        //Sayfa başlığının “YouTube” oldugunu test edin

        String actualTitle = driver.getTitle();
        String expectedTitle = "YouTube";
        Assert.assertEquals(actualTitle, expectedTitle);

    }
    @Test
    public void imageTest(){
        //YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement logoElementi= driver.findElement(By.xpath("(//*[@id='logo-icon'])[2]"));
        Assert.assertTrue("Youtube resmi gözükmüyor",logoElementi.isDisplayed());


    }
    @Test
    public void searchBoxTest(){
        //Search Box 'in erisilebilir oldugunu test edin (isEnabled())

        WebElement searchBoxTest = driver.findElement(By.xpath("//*[@placeholder='Ara']"));
        Assert.assertTrue(searchBoxTest.isEnabled());

    }
    @Test
    public void wrongTitleTest(){
        String actualTitle2=driver.getTitle();
        String istenmeyenTittle="youtube";
        Assert.assertFalse(actualTitle2, Boolean.parseBoolean(istenmeyenTittle));


    }





}