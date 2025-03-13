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

import java.util.HashMap;
import java.util.Map;

public class BaseTest {


    protected BasePage hooks;
    protected HomePage homePage;

    protected WebDriver driver;

    @BeforeClass
    public void SetUp(){

        ChromeOptions  options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false); // Deshabilita autocompletado de contraseñas
        prefs.put("profile.password_manager_enabled", false); // Desactiva el gestor de contraseñas
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-save-password-bubble"); // Desactiva la burbuja de "Guardar Contraseña"
        options.addArguments("--disable-popup-blocking"); // Bloquea cualquier pop-up inesperado
        options.addArguments("--disable-features=PasswordLeakDetection,AutofillServerCommunication");
        options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        System.setProperty("selenium-manager.mode", "ALWAYS");

        driver = new ChromeDriver(options);
        goHome();
        driver.manage().window().maximize();
        hooks =  new BasePage(driver);
        homePage = new HomePage(driver);
        var pageTitle = driver.getTitle();
        System.out.println(pageTitle);
    }
    @BeforeMethod
    public void goHome(){

        driver.get("https://www.saucedemo.com");
    }

    public void tearDown()
    {driver.quit();}

}
