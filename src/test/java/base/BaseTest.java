package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaseTest {


    protected WebDriver driver;

    @Test
    public void SetUp(){

        ChromeOptions  options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome\\chrome.exe");
        System.setProperty("selenium-manager.mode", "ALWAYS");
        driver = new ChromeDriver(options);

        driver.get("https://www.google.com");
        var pageTitle = driver.getTitle();
        System.out.println(pageTitle);
    }

}
