package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends  BasePage {

    public HomePage(WebDriver driver){
        super(driver);
    }

    //Locators
    private By loginLogo= By.xpath("//div[@class='login_logo']");
    @FindBy(xpath ="//input[@id='user-name']" )
    private WebElement userNameField;


    @FindBy(xpath ="//input[@id='password']" )
    private WebElement userPWDField;
    @FindBy(xpath ="//input[@id='login-button']" )
    private WebElement loginButton;


    public boolean waitUntilPage() throws Exception{
        return  isDisplayed(loginLogo);
    }
    public void setUserName(String username) throws Exception{
        sendElementText(userNameField,username);
    }
    public void setUserPWDField(String pwd) throws Exception{
        sendElementText(userPWDField,pwd);
    }
    public ItemsPage clickLoginButton() throws Exception
    {
        click(loginButton);
        return  new ItemsPage(driver);
    }

}
