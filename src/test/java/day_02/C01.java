package day_02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        ////2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın (verify),
        //        // eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        driver.navigate().to("https://youtube.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        String currentTitle = driver.getTitle();
        String expectedTitle = "youtube";

        if (currentTitle.contains(expectedTitle) ) {

            System.out.println("Sayfa Basligi "+expectedTitle+" "+ "iceriyor");
        }else {
            System.out.println("Sayfa Basligi "+expectedTitle+" "+ "icermiyor");
            System.out.println(driver.getTitle());
        }

     //3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın,
        // içermiyorsa actual URL'yi yazdırın.

        String currentUrl =driver.getCurrentUrl();
        String expectedUrl = "youtube";

        if (currentUrl.contains(expectedUrl)) {


            System.out.println("Sayfa URLsi"+expectedUrl+" "+ "iceriyor");
        }else {
            System.out.println("Sayfa URLsi "+expectedUrl+" "+ "icermiyor");
            System.out.println(driver.getCurrentUrl());
        }

        //4. Daha sonra Amazon sayfasina gidin https://www.amazon.com

        driver.navigate().to("https://www.amazon.com");

        //5. Youtube sayfasina geri donun
        driver.navigate().back();

        //6. Sayfayi yenileyin

        driver.navigate().refresh();

        //7. Amazon sayfasina donun

        driver.navigate().forward();

        //8. Sayfayi tamsayfa yapin

        driver.manage().window().fullscreen();

        //9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın,
        // Yoksa doğru başlığı(Actual Title) yazdırın.

        String amazonTitle= driver.getTitle();
        String expectedAmozonTitle="Amazon";

        if (amazonTitle.contains(expectedAmozonTitle)){
            System.out.println("Sayfa basligi "+ expectedAmozonTitle+" "+"iceriyor");

        }else {
            System.out.println("Sayfa basligi "+ expectedAmozonTitle+" "+"icermiyor");
            System.out.println(driver.getTitle());
        }

        //10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın,
        // degilse doğru URL'yi yazdırın

        String amazonUrl= driver.getCurrentUrl();
        String expectedAmazonUrl = "https://www.amazon.co";

        if (amazonUrl.equals(expectedAmazonUrl)){

            System.out.println("URL Test PASS");
        }else{
            System.out.println("URL Test FAILD");
            System.out.println(driver.getCurrentUrl());

        }

        //11.Sayfayi kapatin
        driver.close();


    }
}
