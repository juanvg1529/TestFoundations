package testCases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PurchaseSauceDemoTest extends BaseTest {

    @Test
    public void pruchaseItem()throws Exception{

        var loginPage=homePage.waitUntilPage();
        homePage.setUserName("standard_user");
        homePage.setUserPWDField("secret_sauce");
        var itemsPage=homePage.clickLoginButton();
        itemsPage.printConsole("LOGIN SUCCESSFUL");
        var isIstemsPageDisplayed = itemsPage.isInventoryDisplayed();
        if( isIstemsPageDisplayed){
            List<String> itemsToBuy= new ArrayList<String>();
            List<String> priceItemsToBuy= new ArrayList<String>();
            List<String> priceItemsToBuyCarPage= new ArrayList<String>();
            List<String> namesItemsCartPage= new ArrayList<String>();

            itemsToBuy.add("Sauce Labs Backpack");
            itemsToBuy.add("Sauce Labs Bike Light");
            itemsToBuy.add("Sauce Labs Bolt T-Shirt");
            for (String item:itemsToBuy) {

                var itemToBuy= itemsPage.addItemToTheCart(item);
                itemsPage.printConsole("Item to Buy => " +itemToBuy);
            }
            for (String item:itemsToBuy) {
                Thread.sleep(1000);
                var price = itemsPage.getPrice(item);
                priceItemsToBuy.add(price);
            }

            Assert.assertTrue(itemsPage.areItemsAddedTotheCart().equals("3"),"the items are not completed to buy");

            for (String item:itemsToBuy) {
                var checkRemoval= itemsPage.checkMessageButton(item);
                Assert.assertTrue(checkRemoval,"Mensaje del boton no cambio");
            }

            if(itemsPage.areItemsAddedTotheCart().equals("3")){

                var cartPage= itemsPage.goToCheckoutItems();
                for (String item:itemsToBuy) {
                    Thread.sleep(1000);
                    var price = cartPage.getPrice(item);
                    priceItemsToBuyCarPage.add(price);
                }
                for (String item:itemsToBuy) {
                    Thread.sleep(1000);
                    var nameItem = cartPage.getNameItemsCart(item);
                    namesItemsCartPage.add(nameItem);
                }
                for (int i = 0; i < priceItemsToBuy.size(); i++) {
                    Assert.assertEquals(priceItemsToBuy.get(i), priceItemsToBuyCarPage.get(i),
                            "the price of the item do not match.");
                }
                for (int i = 0; i < namesItemsCartPage.size(); i++) {
                    Assert.assertEquals(namesItemsCartPage.get(i), itemsToBuy.get(i),
                            "the name of the item do not match.");
                }
                cartPage.printConsole("Elements all present in the cart");
                var checkoutPage= cartPage.clickCheckout();
                checkoutPage.setFirstName("Juan Diego");
                checkoutPage.setLastName("Vera G");
                checkoutPage.setPostalCode("0510574");
                var overViewPage= checkoutPage.clickContinueButton();

                String totalPrice=null;
                float valuesPrices=0;
                for (int i = 0; i <priceItemsToBuy.size(); i++) {
                      valuesPrices=Float.parseFloat(priceItemsToBuy.get(i))+valuesPrices;
                     totalPrice= String.valueOf(valuesPrices);

                }
                var subtotalValue=overViewPage.getSubtotalSumValue();
                Assert.assertTrue(subtotalValue.contains(totalPrice), "the sum of the values is not the same as the subtotal");
                var finishPage= overViewPage.clickFinishButton();

            }






        }

    }
}
