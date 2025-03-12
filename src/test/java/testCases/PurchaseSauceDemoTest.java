package testCases;

import base.BaseTest;
import org.testng.annotations.Test;

public class PurchaseSauceDemoTest extends BaseTest {

    @Test
    public void pruchaseItem()throws Exception{

        var loginPage=homePage.waitUntilPage();
        homePage.setUserName("standard_user");
        homePage.setUserPWDField("secret_sauce");
        var itemsPage=homePage.clickLoginButton();
        itemsPage.printConsole("LOGIN SUCCESSFUL");

    }
}
