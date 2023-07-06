package test.java;

import main.java.pages.SortableDataTablesPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataTablesTest extends Hooks {

    @DataProvider(name = "table-test-data")
    public Object[][] tableDataProviderFunc(){
        return new Object[][]{
                {"Table 1","Last Name", 2, "$100.00"},
                {"Table 2","First Name", "Due", 2, "$50"}
                //{"Table 1", "Email", "Due", 2},
                //{"Table 2", "Web Site", "Due", 2}
        };
    }

    @Test(dataProvider = "table-test-data")
    public void testSortByColumnAndCheckRecord2ForDue(String table, String column, Integer row, String expected){
        SortableDataTablesPage sortableDataTablesPage = homePage.clickSortableDataTables();
        sortableDataTablesPage.orderByColumnInTable(table, column);
        Assert.assertEquals(sortableDataTablesPage.getCurrentDueValue(table, row), expected);

    }


}
