package day_01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "resources/drivers/chromedriver.exe");

        WebDriver driver=new ChromeDriver();

      driver.navigate().to("https://www.youtube.com");
      driver.navigate().to("https://www.amazon.com");
      driver.navigate().back();
      driver.navigate().forward();
      driver.navigate().refresh();
      driver.close();


    }
}
