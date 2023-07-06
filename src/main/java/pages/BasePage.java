package main.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    protected void clickElement(WebElement element) {
        waitElementToBeClickeable(element);
        element.click();
    }

    protected void addText(WebElement element, String word) {
        waitVisibilityOfElement(element);
        element.sendKeys(word);
    }

    public void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    protected void waitElementToBeClickeable(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(Exception.class);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitVisibilityOfElement(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(Exception.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected Select findDropDownElement(WebElement dropdown){
        return new Select(dropdown);
    }

    protected WebElement getElementFromList(List<WebElement> elements, String text){
        for(WebElement e : elements){
            if(e.getText().equals(text)){
                return e;
            }
        }
        throw new NoSuchElementException("Cannot find element.");
    }

    protected void doubleClick(WebElement element){
        Actions action = new Actions(driver);
        action.doubleClick(element).perform();
    }
}
