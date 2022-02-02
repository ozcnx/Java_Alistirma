package day0201;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BaseTest;

public class C04 extends BaseTest {
    //● https://the-internet.herokuapp.com/iframe adresine gidin.
    //● Bir metod olusturun: iframeTest
    //○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
    //○ Text Box’a “Merhaba Dunya!” yazin.
    //○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
    //dogrulayin ve konsolda yazdirin.

    @Test
    public void iframeTest(){
        driver.get("https://the-internet.herokuapp.com/iframe");

        WebElement baslik= driver.findElement(By.tagName("h3"));
        SoftAssert options= new SoftAssert();
        options.assertTrue(baslik.isEnabled());


        WebElement iframe= driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);

        WebElement textBox=driver.findElement(By.xpath("//*[text()='Your content goes here.']"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dünya");

        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("(//a[@target='_blank'])[2]")).click();

        WebElement link= driver.findElement(By.xpath("//p[text()='Sponsored by ']"));

        options.assertTrue(link.isDisplayed(), "Yazi gözükmüyor");

        options.assertAll();


    }



}
