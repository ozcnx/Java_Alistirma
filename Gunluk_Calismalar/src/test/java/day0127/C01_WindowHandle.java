package day0127;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class C01_WindowHandle {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }
    @Test
    public void test01() {
        driver.get("https://www.amazon.com");
        String handle1=driver.getWindowHandle();
        System.out.println("Ilk sayfanin handle degeri : "+driver.getWindowHandle());

        driver.switchTo().newWindow(WindowType.WINDOW);//yeni bir pencere acilir
        driver.get("https://www.bestbuy.com");
        String handle2=driver.getWindowHandle();
        System.out.println("Ikinci sayfanin handle degeri : "+driver.getWindowHandle());

       Set<String> HandleDegerleri = driver.getWindowHandles();
        System.out.println(HandleDegerleri);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.facebook.com");

        driver.switchTo().window(handle1);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);

        driver.switchTo().window(handle2);
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));

        HandleDegerleri=driver.getWindowHandles();
        
        String handle3="";

        for (String each:HandleDegerleri
        ) {
            if (!each.equals(handle1) || !each.equals(handle2)) {

                handle3=each;

            }
            System.out.println(handle3);
            System.out.println(HandleDegerleri);

            driver.switchTo().window(handle3);
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/" );
            
        }

    }


}
