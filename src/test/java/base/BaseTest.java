package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;

public class BaseTest {


    protected BasePage hooks;
    protected HomePage homePage;

    protected WebDriver driver;

    @BeforeClass
    public void SetUp(){

        ChromeOptions  options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome\\chrome.exe");
        System.setProperty("selenium-manager.mode", "ALWAYS");
        driver = new ChromeDriver(options);
        goHome();
        hooks =  new BasePage(driver);
        homePage = new HomePage(driver);
        var pageTitle = driver.getTitle();
        System.out.println(pageTitle);
    }
    @BeforeMethod
    public void goHome(){
        driver.get("https://www.saucedemo.com");
    }
    @AfterClass
    public void tearDown()
    {driver.quit();}

}
