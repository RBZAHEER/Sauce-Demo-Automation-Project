package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);  // ADD THIS LINE
    }

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement passwd;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    public void sendUsername(String username1) throws FileNotFoundException {
        username.sendKeys(username1);
    }

    public void sendPass(String password){
        passwd.sendKeys(password);
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }

    public ProductsPage login(String username,String pass) throws FileNotFoundException {

        sendUsername(username);

        sendPass(pass);

        clickLoginBtn();


        return new ProductsPage(driver);
    }

}
