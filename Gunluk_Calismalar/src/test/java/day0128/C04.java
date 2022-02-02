package day0128;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C04 {
    WebDriver driver;
    WebElement dropDown;
    Select select;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();


    }
    @Test
    public void test1(){
        //● https://www.amazon.com/ adresine gidin
        //- Test 1
        //	Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin


        driver.get("https://www.amazon.com/");
        dropDown = driver.findElement(By.id("searchDropdownBox"));
        select =new Select(dropDown);
        List<WebElement> list=select.getOptions();

        int actualSize = list.size();
        int expectedSize =45;

        Assert.assertEquals(actualSize, expectedSize);

    }
    @Test
    public void test2(){
        //-Test 2
        //	1. Kategori menusunden Books secenegini  secin
        //	2. Arama kutusuna Java yazin ve aratin

        select.selectByVisibleText("Books");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER );

    }








}
