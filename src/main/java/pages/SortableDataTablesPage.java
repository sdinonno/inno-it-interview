package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.List;

public class SortableDataTablesPage extends BasePage {

    @FindBy(css = "#table1 .header > span")
    private List<WebElement> columnNamesTable1;

    @FindBy(css = "#table2 .header > span")
    private List<WebElement> columnNamesTable2;

    @FindBy(css = "#table1 > tbody td:nth-child(4)")
    private List<WebElement> dueColumnValuesT1;

    @FindBy(css = "#table2 > tbody td:nth-child(4)")
    private List<WebElement> dueColumnValuesT2;


    public SortableDataTablesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void orderByColumnInTable(String table, String column){
        if(table.equals("Table 1")){
            doubleClick(getElementFromList(columnNamesTable1, column));
        }
        else
            doubleClick(getElementFromList(columnNamesTable2, column));
    }

    public String getCurrentDueValueInRow(String table, Integer row){
        List<String> dueValues = new ArrayList<String>();
        if(table.equals("Table 1")){
            for(WebElement e : dueColumnValuesT1) { dueValues.add(e.getText()); }
        }
        else{
            for(WebElement e : dueColumnValuesT2) { dueValues.add(e.getText()); }
        }
        return dueValues.get(row-1);
    }
}
