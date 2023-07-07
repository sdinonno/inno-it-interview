import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SortableDataTablesPage;

public class SoursableDataTablesTest extends BaseTest {

    @DataProvider(name = "table-test-data")
    public Object[][] tableDataProviderFunc(){
        return new Object[][]{
                {"Table 1","Last Name", 2, "$100.00"},
                {"Table 2","First Name", 2, "$50.00"},
                {"Table 1", "Email", 2, "$50.00"},
                {"Table 2", "Web Site", 2, "$50.00"}
        };
    }

    @Test(dataProvider = "table-test-data")
    public void testSortByColumnAndCheckRecord2ForDue(String table, String column, Integer rowToCheck, String expected){
        SortableDataTablesPage sortableDataTablesPage = homePage.clickSortableDataTables();
        sortableDataTablesPage.orderByColumnInTable(table, column);
        Assert.assertEquals(sortableDataTablesPage.getCurrentDueValueInRow(table, rowToCheck), expected);
    }


}
