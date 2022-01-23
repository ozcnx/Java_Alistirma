package day_01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02 {
    public static void main(String[] args) {
        //1. Yeni bir package olusturalim : day01
        //2. Yeni bir class olusturalim : C01_GetMethods
        //3. Amazon sayfasina gidelim. https://www.amazon.com/
        //4. Sayfa basligini(title) yazdirin
        //5. Sayfa basliginin “Amazon” icerdigini test edin
        //6. Sayfa adresini(url) yazdirin
        //7. Sayfa url’inin “amazon” icerdigini test edin.
        //8. Sayfa handle degerini yazdirin
        //9. Sayfa HTML kodlarinda “alisveris” kelimesi gectigini test edin
        //10. Sayfayi kapatin.

        System.setProperty("webdriver.chrome.driver","resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.amazon.com");

        //4
        System.out.println(driver.getTitle());

        //5
        String currentTitle= driver.getTitle();
        String expectedTitle="Amazon";

        if (currentTitle.contains(expectedTitle) ) {
            System.out.println("Sayfa Baslisi Amazon iceriyor"); //2

        }else{
            System.out.println("Sayfa Baslisi Amazon icermiyor");
        }

        //6

        driver.getCurrentUrl();

        //7
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl= "amazon";

        if (currentUrl.contains(expectedUrl)){
            System.out.println("Url"+" "+expectedUrl+" "+"iceriyor");
        }else {
            System.out.println("Url"+" "+expectedUrl+" "+"icermiyor");
        }

        //8

        driver.getWindowHandle();

        //9
        String webSource =driver.getPageSource();
        String expectedSource="alisveris";

        if (webSource.contains(expectedSource)){

            System.out.println("HTML Kodlari"+" "+expectedSource+" "+"iceriyor");
        }else {
            System.out.println("HTML Kodlari"+" "+expectedSource+" "+"icermiyor");
        }
    //9
        driver.close();

    }
}
