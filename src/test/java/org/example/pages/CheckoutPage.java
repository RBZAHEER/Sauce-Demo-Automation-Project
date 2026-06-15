package org.example.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckoutPage {


    private WebDriver driver;


    public CheckoutPage(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver,this);

    }



    @FindBy(name="firstName")
    private WebElement firstName;


    @FindBy(id="last-name")
    private WebElement lastName;


    @FindBy(id="postal-code")
    private WebElement zipCode;


    @FindBy(id="continue")
    private WebElement continueBtn;


    @FindBy(id="finish")
    private WebElement finishBtn;


    @FindBy(className="complete-header")
    private WebElement successMsg;




    public void enterCheckoutInfo(
            String first,
            String last,
            String postal){


        firstName.sendKeys(first);

        lastName.sendKeys(last);

        zipCode.sendKeys(postal);

        continueBtn.click();

    }




    public void clickFinish(){

        finishBtn.click();

    }



    public String getSuccessMessage(){

        return successMsg.getText();

    }

}