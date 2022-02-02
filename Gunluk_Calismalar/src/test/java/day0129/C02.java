package day0129;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.BaseTest;

import java.util.List;

public class C02 extends BaseTest {

    // Yeni bir Class Olusturun : C03_SoftAssert
    // 1. “http://zero.webappsecurity.com/” Adresine gidin
    // 2. Sign in butonuna basin
    // 3. Login kutusuna “username” yazin
    // 4. Password kutusuna “password” yazin
    // 5. Sign in tusuna basin
    // 6. Pay Bills sayfasina gidin
    // 7. “Purchase Foreign Currency” tusuna basin
    // 8. “Currency” drop down menusunden Eurozone’u secin
    // 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
    // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"

    @Test
    public void test(){
        driver.get("http://zero.webappsecurity.com/");

        driver.findElement(By.id("signin_button")).click();

        driver.findElement(By.name("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.xpath("//*[@value='Sign in']")).click();

        driver.findElement(By.xpath("//*[text()='Pay Bills']")).click();

        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();

        WebElement DropDown=driver.findElement(By.id("pc_currency"));
        Select select = new Select(DropDown);
        select.selectByValue("EUR");

        SoftAssert softassert=new SoftAssert();

        String actual=select.getFirstSelectedOption().getText();
        String expected= "Eurozone (euro)";

        Assert.assertEquals(actual, expected);

        List<WebElement> list=select.getOptions();
        String actual1="";
        String expected1="\"Select One\", \"Australia (dollar)\", \"Canada (dollar)\",\"Switzerland (franc)\",\"China (yuan)\",\"Denmark (krone)\",\"Eurozone (euro)\",\"Great Britain (pound)\",\"Hong Kong (dollar)\",\"Japan (yen)\",\"Mexico (peso)\",\"Norway (krone)\",\"New Zealand (dollar)\",\"Sweden (krona)\",\"Singapore (dollar)\",\"Thailand (baht)\"";

        for (WebElement w:list
             ) {
            actual1+=w.getText() + " ";
        }



    }





}
