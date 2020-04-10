package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Sample1Test {
        public String baseUrl = "http://demo.guru99.com/test/newtours/";
        public WebDriver chromeDriver = new ChromeDriver();
        @BeforeTest
        public void start() {

            //WebDriver safariDriver = new SafariDriver();
            //WebDriver chromeDriver = new ChromeDriver();


            //safariDriver.get(baseUrl);
            chromeDriver.get(baseUrl);
        }
        @Test
        public void main() {
            //System.out.println("Safari title = " + safariDriver.getTitle());
            String title = chromeDriver.getTitle();
            //safariDriver.quit();
            Assert.assertEquals(title, "Welcome: Mercury Tours");

        }

        @AfterTest
        public void quit() {


            chromeDriver.quit();
        }

}
