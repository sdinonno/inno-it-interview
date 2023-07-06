package main.java.pages;

import org.openqa.selenium.WebDriver;
import test.java.BasicAuthTest;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public BasicAuthPage clickBasicAuth(){
        clickLink("Basic Auth");
        return new BasicAuthPage(driver);
    }

    public LoginPage clickFormAuthentication(){
        clickLink("Form Authentication");
        return new LoginPage(driver);
    }

    public DropdownPage clickDropDown(){
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }

    public SortableDataTablesPage clickSortableDataTables(){
        clickLink("Sortable Data Tables");
        return new SortableDataTablesPage(driver);
    }
}
