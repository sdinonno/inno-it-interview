package test.java;

import main.java.pages.DropdownPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownTest extends Hooks {

    @DataProvider(name = "options-test-data")
    public Object[][] optionsDataProvider(){
        return new Object[][]{
                {"Option 1"},
                {"Option 2"}
        };
    }

    @Test(dataProvider = "options-test-data")
    public void testSelectOption(String option){
        DropdownPage dropDownPage = homePage.clickDropDown();
        dropDownPage.selectFromDropDown(option);
        List<String> selectedOptions = dropDownPage.getSelectedOptions();
        Assert.assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        Assert.assertTrue(selectedOptions.contains(option), "Option not selected");
    }

}
