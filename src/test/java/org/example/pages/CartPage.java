package org.example.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CartPage {


    private WebDriver driver;


    public CartPage(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver,this);

    }



    @FindBy(className="inventory_item_name")
    private WebElement productName;



    @FindBy(id="checkout")
    private WebElement checkoutBtn;




    public String getProductName(){

        return productName.getText();

    }



    public CheckoutPage clickCheckout(){

        checkoutBtn.click();


        return new CheckoutPage(driver);

    }

}