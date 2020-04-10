package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


public class AlertDemoTest {
    public WebDriver driver = new ChromeDriver();
    public WebDriverWait wait = new WebDriverWait(driver, 20);
    @BeforeClass
    public  void start() {


        // Alert Message handling
        driver.get("http://demo.guru99.com/test/delete_customer.php");
    }

    @Test
    public void main() {
        driver.findElement(By.name("cusid")).sendKeys("53920");
        driver.findElement(By.name("submit")).click();

        wait.until(ExpectedConditions.alertIsPresent());
        // Switching to Alert
        Alert alert = driver.switchTo().alert();

        // Capturing alert message.
        String alertMessage = alert.getText();



        Assert.assertEquals(alertMessage, "Do you really want to delete this Customer?");
        // Accepting alert
        alert.accept();
    }
    @Test
    public void main2() {
        wait.until(ExpectedConditions.alertIsPresent());

        // Switching to Alert
        Alert alert2 = driver.switchTo().alert();

        // Capturing alert message.
        String alertMessage2 = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage2, "Customer Successfully Delete!");
    }
    @AfterTest
    public void quit(){
        driver.quit();

    }

}