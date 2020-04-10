package test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ValidationDemoTest {
    public String baseUrl = "http://demo.guru99.com/V1/index.php";
    public WebDriver driver = new ChromeDriver();
    public WebDriverWait wait = new WebDriverWait(driver, 20);

    @BeforeTest
    public void strat() {

        driver.get(baseUrl);
    }
    @Test(priority = 0)
    public void main() {
        WebElement usernameControl = driver.findElement(By.name("uid"));
        WebElement passwordControl = driver.findElement(By.name("password"));
        WebElement misc = driver.findElement(By.cssSelector("body"));
        WebElement userValidationMessage = driver.findElement(By.id("message23"));
        WebElement passwordValidationMessage = driver.findElement(By.id("message18"));


        usernameControl.click();
        passwordControl.click();
        misc.click();


        Assert.assertEquals(userValidationMessage.getAttribute("style"), "visibility: visible;");
        Assert.assertEquals(passwordValidationMessage.getAttribute("style"), "visibility: visible;");
    }
    @Test(priority = 1)
    public void main2(){
        WebElement usernameControl = driver.findElement(By.name("uid"));
        WebElement passwordControl = driver.findElement(By.name("password"));
        WebElement userValidationMessage = driver.findElement(By.id("message23"));
        WebElement passwordValidationMessage = driver.findElement(By.id("message18"));

        usernameControl.sendKeys("a");
        passwordControl.sendKeys("a");


        Assert.assertEquals(userValidationMessage.getAttribute("style"),"visibility: hidden;");
        Assert.assertEquals(passwordValidationMessage.getAttribute("style"),"visibility: hidden;");
    }
    @AfterTest
    public void close(){
        driver.quit();
    }

}
