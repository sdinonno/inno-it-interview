package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = "button[type=submit]")
    private WebElement loginButton;

    @FindBy(id = "flash")
    private WebElement alertErrorMessage;

    @FindBy(css = "#content h2")
    private WebElement title;

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

    public String getAlertErrorText(){
        return alertErrorMessage.getText();
    }

    public String getLoginTitle(){
        return title.getText();
    }
}
