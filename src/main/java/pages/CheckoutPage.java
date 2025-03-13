package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "first-name")
    private WebElement firstNamefield;

    @FindBy(id = "last-name")
    private WebElement lastNamefield;
    @FindBy(id = "postal-code")
    private WebElement zipcode;

    @FindBy(id = "continue")
    private WebElement continueButton;

    public void setFirstName(String firstName) throws Exception{
        this.sendElementText(firstNamefield,firstName);
    }
    public void setLastName(String lastName) throws Exception{
        this.sendElementText(lastNamefield,lastName);
    }
    public void setPostalCode(String postalCode) throws Exception{
        this.sendElementText(zipcode,postalCode);
    }
    public OverViewPage clickContinueButton() throws Exception{
        this.click(continueButton);
        return new OverViewPage(driver);
    }
}
