package day_04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03 {
   WebDriver driver;

   @Before
    public void setup() {

       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       driver.manage().window().maximize();

   }
   @Test
    public void test1() {
       driver.get("https://www.facebook.com");
       driver.findElement(By.xpath("//*[text()='Tüm Çerezlere İzin Ver']")).click();
       driver.findElement(By.xpath("//*[@data-testid='open-registration-form-button']")).click();
       driver.findElement(By.xpath("(//*[@value='2'])[3]")).click();

   }
   @After
    public void teardown() {

       //driver.close();
   }
}
