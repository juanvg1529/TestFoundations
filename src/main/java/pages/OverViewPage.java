package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverViewPage extends BasePage {

    public OverViewPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    private WebElement subtotalElement;
    @FindBy(id= "finish")
    private WebElement finishButton;
    public String getSubtotalSumValue() throws Exception{
       return  this.getText(subtotalElement);
    }

    public FinishPage clickFinishButton() throws  Exception{
        this.click(finishButton);
        return new FinishPage(driver);
    }


}
