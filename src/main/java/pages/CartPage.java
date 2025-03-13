package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage
{
    public CartPage (WebDriver driver){
        super(driver);
    }


    @FindBy(id = "checkout")
    private WebElement checkoutButton;
    public String getPrice(String itemToBuy) {
        String priceItemSelected = null;

        List<WebElement> cartItems = driver.findElements(By.xpath("//div[@class='cart_item']"));

        for (WebElement item : cartItems) {

            String productName = item.findElement(By.xpath(".//div[@class='inventory_item_name']")).getText();
            if(productName.contains(itemToBuy)){
                priceItemSelected = item.findElement(By.xpath(".//div[@class='inventory_item_price']")).getText().replace("$","");

            }
        }
        return priceItemSelected;
    }

    public String getNameItemsCart(String itemToBuy) {
        String nameItemSelected = null;

        List<WebElement> cartItems = driver.findElements(By.xpath("//div[@class='cart_item']"));

        for (WebElement item : cartItems) {

            String productName = item.findElement(By.xpath(".//div[@class='inventory_item_name']")).getText();
            if(productName.contains(itemToBuy)){
                nameItemSelected=productName;

            }
        }
        return nameItemSelected;
    }

    public CheckoutPage clickCheckout() throws  Exception{
        this.click(checkoutButton);
        return  new CheckoutPage(driver);
    }

}
