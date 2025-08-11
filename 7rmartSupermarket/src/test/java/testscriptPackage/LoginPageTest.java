package testscriptPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginPageTest extends Base{
	
	@DataProvider(name = "Login Credentials")
	public Object[][] credentials(){
		return new Object[][]{{"admin45","admin12"},{"admin","admin12"},{"admin45","admin"}};
	}
	
  @Test(dataProvider = "Login Credentials",groups = {"smoke"} )
  public void verifyInvalidCredentials(String username, String passWord) {
	  
	  LoginPage loginpage = new LoginPage(driver);
	  
	  loginpage.enterUsernameAndPassword(username, passWord);
	  
	  loginpage.clickSignIn();
	  
	  Assert.assertTrue(loginpage.alertInvalidCredentialsIsDiaplayed(), Constants.ERRORLOGINMSG);
  }
  
  @Test
  @Parameters({"username","passWord"})
  
  public void verifyValidCredential(String username, String passWord) {
	  LoginPage loginpage = new LoginPage(driver);
	  
	  loginpage.enterUsernameAndPassword(username, passWord);
	  
	  loginpage.clickSignIn();
	  
	  boolean isHomePageIsLoaded = loginpage.dashboardIsDisplayed();
	  
	  Assert.assertTrue(isHomePageIsLoaded, Constants.ERRORLOGINMSG);
	  
	 
  }
  
  @Test(groups = {"smoke"})
  
  public void loginWithValidUserName() throws IOException {
	  
	  String userName = ExcelUtility.getStringData(1, 0, "LoginPageTest");
	  String password = ExcelUtility.getStringData(1, 1, "LoginPageTest");
	  LoginPage loginpage = new LoginPage(driver);
	  
	  loginpage.enterUsernameAndPassword(userName, password);
	  
	  loginpage.clickSignIn();
	  
	  boolean isHomePageIsLoaded = loginpage.dashboardIsDisplayed();
	  
	  Assert.assertTrue(isHomePageIsLoaded, Constants.ERRORLOGINMSG);
	  
  }
  
  @Test
  
  public void loginWithInValidPassword() throws IOException {
	  
	  String userName = ExcelUtility.getStringData(3, 0, "LoginPageTest");
	  String password = ExcelUtility.getStringData(3, 1, "LoginPageTest");
	  
	  LoginPage loginpage = new LoginPage(driver);
	  
	  loginpage.enterUsernameAndPassword(userName, password);
	  
	  loginpage.clickSignIn();
	  
	  Assert.assertTrue(loginpage.alertInvalidCredentialsIsDiaplayed(), Constants.ERRORLOGINMSG);
	  
  }
  
}
