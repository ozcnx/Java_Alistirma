package day_04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
    static WebDriver driver;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }
    @Test
    public void test(){
        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

        //2. Username kutusuna “standard_user” yazdirin
        WebElement usernameElement = driver.findElement(By.xpath("//*[@placeholder='Username']"));
        usernameElement.sendKeys("standard_user");

        //3. Password kutusuna “secret_sauce” yazdirin
        WebElement passwordElementi = driver.findElement(By.xpath("//input[@id='password']"));
        passwordElementi.sendKeys("secret_sauce");

        //4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin

        WebElement UrunElementi= driver.findElement(By.xpath("//*[@id='item_4_title_link']"));
        String urunElementi=UrunElementi.getText();
        UrunElementi.click();

        //6. Add to Cart butonuna basin

        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();

        //7. Alisveris sepetine tiklayin

        driver.findElement(By.xpath("//*[@class='shopping_cart_link']")).click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement sepetElementi=driver.findElement(By.xpath("//*[@class='inventory_item_name']"));
        String sepet= sepetElementi.getText();
        Assert.assertEquals(sepet, urunElementi);

       ////9. Sayfayi kapatin
        driver.close();

    }

















}
