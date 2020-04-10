package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Sample2Test {
    public WebDriver driver = new ChromeDriver();

    public String baseUrl = "http://demo.guru99.com/test/login.html";

    @BeforeClass
    public void start() {

        // declaration and instantiation of objects/variables



        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void main1() {
        // Get the WebElement corresponding to the Email Address(TextField)
        WebElement email = driver.findElement(By.id("email"));

        // Get the WebElement corresponding to the Password Field
        WebElement password = driver.findElement(By.name("passwd"));

        email.sendKeys("abcd@gmail.com");
        password.sendKeys("abcdefghlkjl");
        System.out.println("Text Field Set");


        // Deleting values in the text box
        email.clear();
        password.clear();
        System.out.println("Text Field Cleared");

        // Find the submit button
        WebElement login = driver.findElement(By.id("SubmitLogin"));

        // Using click method to submit form
        email.sendKeys("abcd@gmail.com");
        password.sendKeys("abcdefghlkjl");
        Assert.assertTrue(login.isDisplayed());
        login.click();

        System.out.println("Login Done with Click");

    }
    @Test(priority = 2)
    public void main2() {
        //using submit method to submit the form. Submit used on password field
        driver.get(baseUrl);
        driver.findElement(By.id("email")).sendKeys("abcd@gmail.com");
        driver.findElement(By.name("passwd")).sendKeys("abcdefghlkjl");
        WebElement submit = driver.findElement(By.id("SubmitLogin"));
        Assert.assertTrue(submit.isDisplayed());
        System.out.println("Login Done with Submit");
    }
    @AfterTest
    public void close(){
        driver.quit();

    }
}