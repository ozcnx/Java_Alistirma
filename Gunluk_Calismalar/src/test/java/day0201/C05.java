package day0201;

import org.testng.annotations.Test;
import utilities.BaseTest;

public class C05 extends BaseTest {
    //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    //2) sayfadaki iframe sayısını bulunuz.
    //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
    //4) ilk iframe'den çıkıp ana sayfaya dönünüz
    //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
    //tıklayınız


    @Test
    public void iframeTest2(){
        driver.get("http://demo.guru99.com/test/guru99home/");


    }





}
