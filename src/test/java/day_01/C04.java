package day_01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();


        //2. Amazon soyfasina gidelim. https://www.amazon.com/

        driver.navigate().to("https://www.amazon.com/");

        //3. Sayfanin konumunu ve boyutlarini yazdirin
        driver.manage().window().getPosition();
        driver.manage().window().getSize();

        //4. Sayfayi simge durumuna getirin
        driver.manage().window().minimize();

        //5. simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(3000);
        driver.manage().window().maximize();

        //6. Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        System.out.println("sayfa max iken pozisyon :"+driver.manage().window().getPosition());
        System.out.println("sayfa max iken boyutlar ."+ driver.manage().window().getSize());

        //7. Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();

        //8. Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        System.out.println("sayfa full iken pozisyon :"+driver.manage().window().getPosition());
        System.out.println("sayfa full iken boyutlar ."+ driver.manage().window().getSize());

        //9. Sayfayi kapatin
        driver.close();

    }
}