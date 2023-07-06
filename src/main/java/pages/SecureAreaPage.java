package main.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecureAreaPage extends BasePage {

    @FindBy(id = "flash")
    private WebElement alert;

    @FindBy(css = "#content .button")
    private WebElement logOutButton;

    public SecureAreaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getAlertText(){
        return alert.getText();
    }

    public void clickLogOutButton(){
        clickElement(logOutButton);
    }

}
