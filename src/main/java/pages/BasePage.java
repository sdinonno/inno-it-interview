package main.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

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



}
