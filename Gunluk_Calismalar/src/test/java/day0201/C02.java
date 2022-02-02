package day0201;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseTest;

import java.util.List;

public class C02 extends BaseTest {
    //Bir class oluşturun: C3_DropDownAmazon
    //https://www.amazon.com/ adresine gidin.
    //- Test 1
    //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 28
    //oldugunu test edin
    //-Test 2
    //1. Kategori menusunden Books secenegini secin
    //2. Arama kutusuna Java yazin ve aratin
    //3. Bulunan sonuc sayisini yazdirin
    //4. Sonucun Java kelimesini icerdigini test edin

    @Test
    public void kategoriTest(){


        driver.get("https://www.amazon.com/");
        WebElement ddm=driver.findElement(By.id("searchDropdownBox"));
        Select option=new Select(ddm);
        List<WebElement> list=option.getOptions();

        Assert.assertTrue(list.size()==28);

    }
    @Test
    public void ddmTest(){
        driver.get("https://www.amazon.com/");
        WebElement dropDown=driver.findElement(By.id("searchDropdownBox"));
        Select option=new Select(dropDown);
        option.selectByVisibleText("Books");

        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Java"+ Keys.ENTER);
        String sonucYazisi=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        System.out.println(sonucYazisi);

        Assert.assertTrue(sonucYazisi.contains("Java"));


    }


}
