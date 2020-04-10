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




            chromeDriver.get(baseUrl);
        }
        @Test
        public void main() {

            String title = chromeDriver.getTitle();

            Assert.assertEquals(title, "Welcome: Mercury Tours");

        }

        @AfterTest
        public void quit() {


            chromeDriver.quit();
        }

}
