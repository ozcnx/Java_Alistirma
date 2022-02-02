package day0201;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.BaseTest;

import java.time.Duration;

public class C03  {

    //● Bir class olusturun: Alerts
    //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //● Bir metod olusturun: acceptAlert
    //○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    //“You successfully clicked an alert” oldugunu test edin.
    //● Bir metod olusturun: dismissAlert
    //○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //“successfuly” icermedigini test edin.
    //● Bir metod olusturun: sendKeysAlert
    //○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
    WebDriver driver;
    @BeforeClass
    public void test(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();


    }
    @Test
    public void acceptAlertTest(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();
        driver.switchTo( ).alert( ).accept( );

        String sonucYazisi1=driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']")).getText();
        Assert.assertTrue(sonucYazisi1.equals("You successfully clicked an alert"));


    }
    @Test
    public void dissmisseAlertTest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();
        driver.switchTo( ).alert( ).dismiss( );
        String sonucYazisi2=driver.findElement(By.xpath("//*[@id='result']")).getText();

        Assert.assertFalse(sonucYazisi2.contains("successfuly"));




    }
    @Test

    public void sendKeysAlertTest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();

        driver.switchTo().alert().sendKeys("ahsen");
        driver.switchTo().alert().accept();

        String sonucYazisi3=driver.findElement(By.xpath("//*[@id='result']")).getText();

        Assert.assertTrue(sonucYazisi3.contains("ahsen"));



    }


}
