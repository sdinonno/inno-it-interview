package pages;

import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
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
