package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class Sample4Test {
    public String baseUrl = "http://demo.guru99.com/test/yahoo.html";
    public WebDriver driver = new ChromeDriver();


    @BeforeClass
    public void start() {

        driver.get(baseUrl);



    }
    @Test
    public void main() {
        WebElement downloadButton = driver.findElement(By.id("messenger-download"));
        String sourceLocation = downloadButton.getAttribute("href");

        String wgetCommand = "wget -P /Users/danilasokolov/Downloads/test --no-check-certificate " + sourceLocation;

        System.out.println(wgetCommand);
        try {
            Process exec = Runtime.getRuntime().exec(wgetCommand);

            int exitVal = exec.waitFor();
            File f = new File("/Users/danilasokolov/Downloads/test/msgr11us.exe");
            //System.out.println(f.isFile());
            Assert.assertTrue(f.isFile());
            System.out.println("Exit value: " + exitVal);
        }catch (InterruptedException | IOException ex) {
            System.out.println(ex.toString());
        }
    }
    @AfterTest
    public void close(){

        driver.quit();
    }

}