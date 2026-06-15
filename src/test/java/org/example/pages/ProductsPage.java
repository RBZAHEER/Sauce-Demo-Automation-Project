package org.example.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductsPage {


    private WebDriver driver;


    public ProductsPage(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver,this);

    }


    @FindBy(xpath="//span[@class='title']")
    private WebElement productPageTitle;


    @FindBy(id="add-to-cart-sauce-labs-backpack")
    private WebElement addToCartBtn;


    @FindBy(className="shopping_cart_link")
    private WebElement cartButton;



    public boolean isProductPageDisplayed(){

        return productPageTitle.isDisplayed();

    }



    public void addProduct(){

        addToCartBtn.click();

    }



    public CartPage openCart(){

        cartButton.click();


        return new CartPage(driver);

    }

}