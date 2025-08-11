package testscriptPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUserPageSearchUser extends Base{
	
	HomePage homepage;
	AdminUserPage adminuserpage;
	
  @Test
  public void searchUser() throws IOException {
	  
	  String userName = ExcelUtility.getStringData(1, 0, "AdminUserPageTest");
	  String password = ExcelUtility.getStringData(1, 1, "AdminUserPageTest");
	  String infoUserName = ExcelUtility.getStringData(1, 4, "AdminUserPageTest");
	  String userType = ExcelUtility.getStringData(1, 2, "AdminUserPageTest");
	  
	  LoginPage loginpage = new LoginPage(driver);
	  
	  loginpage.enterUsernameAndPassword(userName,password);
	  
	  homepage=loginpage.clickSignIn();
	  
	  adminuserpage = homepage.clickAdminUserMoreInfo();
	  
	  adminuserpage.clickSearch().enterSearchUserName(infoUserName).selectSearchUserType(userType).clickSearchBtn();
	  
	  String actual = adminuserpage.getTextFirstUserName();
	  
	  Assert.assertEquals(actual, infoUserName, Constants.ERRORUSERLISTED);
  }
}
