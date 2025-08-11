package testscriptPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomePageTest extends Base{
	
	HomePage homepage;
  @Test
  public void verifyLogout() throws IOException {
	  
	  String userName = ExcelUtility.getStringData(1, 0, "HomePageTest");
	  String password = ExcelUtility.getStringData(1, 1, "HomePageTest");
	  String expected = ExcelUtility.getStringData(1, 2, "HomePageTest");
	  
	  LoginPage loginpage = new LoginPage(driver);
	  
	  loginpage.enterUsernameAndPassword(userName,password);
	  
	  homepage=loginpage.clickSignIn();
	  
	  /*HomePage homepage = new HomePage(driver);
	  
	  homepage.clickAdminDropDown();
	  
	  homepage.clickLogout();*/
	  
	  //String expected = "Login | 7rmart supermarket";
	  
	  homepage.clickAdminDropDown().clickLogout();
	  
	  String actual = driver.getTitle();
	  
	  Assert.assertEquals(actual, expected, Constants.ERRORLOGOUTMSG);
	  
  }
}
