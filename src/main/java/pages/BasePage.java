package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    public void click(WebElement element)throws Exception{
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        }catch (Exception ex){
            throw  new Exception("Element wasn't possible to click" + element);
        }
    }

    public boolean isDisplayed(By element)throws Exception{
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(element)).isDisplayed();
            return true;
        }catch (Exception ex){
            throw  new Exception("Element isn't displayed" + element);
        }
    }
    public String getText(WebElement element)throws Exception{
        try {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.visibilityOf(element)).getText();
        }catch (Exception ex){
            throw  new Exception("Element isn't wasn't possible to get the text" + element);
        }
    }

    public void sendElementText(WebElement element, String textToSend)throws Exception{
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until((ExpectedConditions.visibilityOf(element))).sendKeys(textToSend);

        }catch (Exception ex){
            throw  new Exception("Wasn't possible to send the text = "+textToSend+" to the element = "+element);
        }
    }

    public void printConsole(String text){
        System.out.println(text);

    }

    public boolean isElementClickable(WebElement element, int time)throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (Exception exception){
            throw  new Exception("Wasn't possible to wait until the element was clickable= "+element);
        }

        return true;
    }

    public void waitUntilElement(WebElement element ,int seconds ){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }


}
