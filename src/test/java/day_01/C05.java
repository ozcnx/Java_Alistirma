package day_01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","resources/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        // 2. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");


        //3. Sayfanin konumunu ve boyutlarini yazdirin

        driver.manage().window().getPosition();
        driver.manage().window().getSize();

        //4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin

        driver.manage().window().setPosition(new Point(-2, -2));
        driver.manage().window().setSize(new Dimension(600, 300));

        //5. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin

        int currentPosX=driver.manage().window().getPosition().getX();
        int currentPosY=driver.manage().window().getPosition().getY();
        int currentSizeEn=driver.manage().window().getSize().width;
        int currentSizeBoy=driver.manage().window().getSize().height;

        Thread.sleep(3000);

        if (currentPosX==-2 && currentPosY==-2 && currentSizeEn==600 && currentSizeBoy==300){
            System.out.println("Olceklendirme testi PASS");
        }else {
            System.out.println("Olceklendirme testi FAILED");
        }


        //8. Sayfayi kapatin
        driver.close();
    }
}
