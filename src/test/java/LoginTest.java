package test.java;

import main.java.pages.LoginPage;
import main.java.pages.SecureAreaPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends Hooks {

    @DataProvider(name = "invalid-username-test-data")
    public Object[][] invalidUsernameDataProviderFunc(){
        return new Object[][]{
                {"sofi","SuperSecretPassword!"},
                {"","SuperSecretPassword!"},
                {"TOMSMITH", "SUPERSECRETPASSWORD!"},
                {"", "SuperSecretPassword!"}
        };
    }

    @DataProvider(name = "invalid-password-test-data")
    public Object[][] invalidPasswordDataProviderFunc(){
        return new Object[][]{
                {"tomsmith","admin"},
                {"tomsmith", ""},
                {"tomsmith", "supersecretpassword!"},
        };
    }

    @DataProvider(name = "valid-test-data")
    public Object[][] validDataProviderFunc(){
        return new Object[][]{
                {"tomsmith","SuperSecretPassword!", "You logged into a secure area!"},
        };
    }

    @Test(dataProvider ="valid-test-data")
    public void testSuccessfulLogin(String userName, String password, String expectedMessage){
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername(userName);
        loginPage.setPassword(password);
        SecureAreaPage secureAreaPage = loginPage.clickLogIn();
        Assert.assertTrue(secureAreaPage.getAlertText().contains(expectedMessage),
                "Alert text is invalid");
    }

    @Test(dataProvider ="invalid-username-test-data")
    public void testLoginWithInvalidUsername(String userName, String password){
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername(userName);
        loginPage.setPassword(password);
        loginPage.clickLogIn();
        Assert.assertEquals(loginPage.getAlertErrorText(), "Your username is invalid!\n" + "×");
    }

    @Test(dataProvider ="invalid-password-test-data")
    public void testLoginWithInvalidPassword(String userName, String password){
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername(userName);
        loginPage.setPassword(password);
        loginPage.clickLogIn();
        Assert.assertEquals(loginPage.getAlertErrorText(), "Your password is invalid!\n" + "×");
    }

    @Test(dataProvider ="valid-test-data")
    public void testLogOut(String userName, String password, String expectedMessage){
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername(userName);
        loginPage.setPassword(password);
        SecureAreaPage secureAreaPage = loginPage.clickLogIn();
        secureAreaPage.clickLogOutButton();
        Assert.assertTrue(loginPage.getLoginTitle().contains("Login"));
    }

}
