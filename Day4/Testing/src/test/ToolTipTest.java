package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ToolTipTest {
    public String baseUrl = "http://demo.guru99.com/test/social-icon.html";

    public WebDriver driver = new ChromeDriver();
    public String expectedTooltip = "Github";
    @BeforeClass
    public void start() {


        driver.get(baseUrl);
    }
    @Test
    public void main() {

        // Find the Github icon at the top right of the header
        WebElement github = driver.findElement(By.xpath(".//*[@class='soc-ico show-round']/a[4]"));

        //get the value of the "title" attribute of the github icon
        String actualTooltip = github.getAttribute("title");
        Assert.assertEquals(actualTooltip,expectedTooltip);
        //Assert the tooltip's value is as expected
        System.out.println("Actual Title of Tool Tip = " + actualTooltip);

        if (actualTooltip.equals(expectedTooltip)) {
            System.out.println("Test Case Passed");
        }
    }
    @AfterTest
    public void close() {
        driver.quit();
    }
}