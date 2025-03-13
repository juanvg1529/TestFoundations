package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemsPage extends BasePage{

    public ItemsPage(WebDriver driver){
        super(driver);
    }

    private By inventoryContainer = By.id("inventory_container");
    @FindBys({
            @FindBy(xpath = "//div[@class='inventory_item']")
    })
    private List< WebElement> inventoryItems;
    @FindBy(xpath = "//div[@class=\"inventory_item_name \"]")
    private  By inventoryItemName = By.className("inventory_item_name");
    @FindBy(xpath = "//button[@class=\"btn btn_primary btn_small btn_inventory \"]")
    private WebElement addButon;
    @FindBy(className = "shopping_cart_link")
    private WebElement cartElement;
    private By shoppingBadge = By.className("shopping_cart_badge");


    public boolean isInventoryDisplayed() throws Exception{
        return this.isDisplayed(inventoryContainer);
    }
    public void addItemToCart(String itemName)  throws  Exception{
        WebElement itemContainer = driver.findElement(By.xpath("//div[@class='inventory_item_name ' and text()='" + itemName + "']"));

        click(addButon);
    }
    public String checkRemoveText(String itemName)  throws  Exception{

        String changeSpace=itemName.toLowerCase().replace(" ","-");
        String newItemName = "remove-"+changeSpace;
        WebElement itemContainer = driver.findElement(By.xpath("//button[@name='"+newItemName+"']"));

        return getText(itemContainer);
    }

    public String getPrice(String itemToBuy) {
        String priceItemSelected = null;

        WebElement itemContainer = driver.findElement(By.xpath("//div[contains(@class, 'inventory_item_name') and text()='" + itemToBuy + "']" ));
        priceItemSelected = itemContainer.findElement(By.xpath("./ancestor::div[contains(@class, 'inventory_item')]//div[contains(@class, 'inventory_item_price')]")).getText();
        priceItemSelected = priceItemSelected.replace("$", "");

        return priceItemSelected;
    }
    public String addItemToTheCart(String itemToBuy) throws Exception{

        String productNameSelected= null;
        for(WebElement element:inventoryItems){
            String productName=element.findElement(inventoryItemName).getText();
            if( itemToBuy.contains(productName)){
                this.addItemToCart(productName);
                this.printConsole("Product Added "+productName);
                productNameSelected = productName;

            }
        }
        return productNameSelected;
    }

    public boolean checkMessageButton(String itemToBuy) throws Exception{
        boolean checkRemove= false;
        String productSelected= null;
        for (WebElement element :inventoryItems) {
            String productName= element.findElement(inventoryItemName).getText();
            if(itemToBuy.contains(productName)){
                var stringRemoved= this.checkRemoveText(productName);
                if(stringRemoved.equals("Remove")){
                    checkRemove=true;

                }
            }
        }
        return checkRemove;
    }

    public String areItemsAddedTotheCart() throws  Exception{
        String numberOfItems=null;
        if(this.isDisplayed(shoppingBadge)){
            numberOfItems=driver.findElement(shoppingBadge).getText();
        }
        return numberOfItems;

    }

    public CartPage goToCheckoutItems() throws Exception{
        this.click(cartElement);

        return new CartPage(driver);
    }


}
