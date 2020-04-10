package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Sample3Test {
    public String baseUrl = "http://demo.guru99.com/test/upload/";
    public WebDriver driver = new ChromeDriver();
    public WebDriverWait wait = new WebDriverWait(driver, 20);

    @BeforeClass
    public void start() {


        driver.get(baseUrl);
        WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));

        // enter the file path onto the file-selection input field
        uploadElement.sendKeys("/Users/danilasokolov/voice_bot/env/pyvenv.cfg");
        driver.findElement(By.id("terms")).click();
    }
    @Test
    public void main() {
        // check the "I accept the terms of service" check box



        WebElement resultElement = driver.findElement(By.cssSelector("#res"));
        WebElement resultText = driver.findElement(By.cssSelector("#res > center"));

        // click the "UploadFile" button
        driver.findElement(By.name("send")).click();


        wait.until(ExpectedConditions.attributeContains(resultElement, "style", "display: block"));
        Assert.assertTrue(resultText.getText().contains(" successfully"));
    }
    @AfterTest
    public void close(){
        driver.quit();

    }
}