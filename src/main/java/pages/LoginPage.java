package main.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = "button[type=submit]")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setUsername(String username){
        addText(usernameField, username);
    }

    public void setPassword(String password){
        addText(passwordField, password);
    }

    public SecureAreaPage clickLogIn(){
        clickElement(loginButton);
        return new SecureAreaPage(driver);
    }
}
