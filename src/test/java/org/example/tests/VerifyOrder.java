package org.example.tests;


import org.example.base.BaseTest;
import org.example.listeners.TestListener;
import org.example.pages.CartPage;
import org.example.pages.CheckoutPage;
import org.example.pages.LoginPage;
import org.example.pages.ProductsPage;
import org.example.utils.ExcelReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

@Listeners(TestListener.class)
public class VerifyOrder extends BaseTest {


    @Test(dataProvider = "excelData")
    public void verify(String usernameexcel, String passwdexcel, String firstName, String lastName, String zipCode) throws FileNotFoundException {
        LoginPage lp = new LoginPage(driver);

        ProductsPage productPage =
                lp.login(usernameexcel, passwdexcel);



        Assert.assertTrue(
                productPage.isProductPageDisplayed()
        );



        productPage.addProduct();



        CartPage cartPage =
                productPage.openCart();



        Assert.assertEquals(
                cartPage.getProductName(),
                "Sauce Labs Backpack"
        );



        CheckoutPage checkoutPage =
                cartPage.clickCheckout();



        checkoutPage.enterCheckoutInfo(
                firstName, lastName, zipCode
        );



        checkoutPage.clickFinish();



        Assert.assertEquals(
                checkoutPage.getSuccessMessage(),
                "Thank you for your order!"
        );

    }
    @DataProvider(name = "excelData")
    public Object [][] getData(){
        return ExcelReader.readExcel("src/test/resources/LoginData.xlsx", "Login");
    }

}