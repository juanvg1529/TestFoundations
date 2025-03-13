package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FinishPage extends BasePage {
    public FinishPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(className = "complete-header")
    private WebElement completeHeaderText;

    public String retriveCompleteText() throws Exception{

        return  this.getText(completeHeaderText);
    }


}
