package day0128;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C02_HandleDropdown {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();


       
       

    }

    @Test
    public void testHandleDropdown() throws InterruptedException {
        driver.get("https://amazon.com");
        WebElement dropdown=driver.findElement(By.id("searchDropdownBox"));
        Select select=new Select(dropdown);
        select.selectByIndex(3);



        System.out.println(select.getFirstSelectedOption().getText());
        Thread.sleep(3000);

        select.selectByVisibleText("Deals");
        Thread.sleep(3000);

        select.selectByValue("search-alias=electronics-intl-ship");

        List<WebElement> optionList = select.getOptions();
        for (WebElement each: optionList
             ) {
            System.out.println(each.getText());
        }


    }

    public void teardown(){
        driver.close();
    }

}
