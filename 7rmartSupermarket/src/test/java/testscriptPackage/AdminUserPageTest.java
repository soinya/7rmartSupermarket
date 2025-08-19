package testscriptPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUserPageTest extends Base{
	
	HomePage homepage;
	AdminUserPage adminuserpage;
	FakerUtility fakerutility = new FakerUtility();
	
  @Test
  public void VerifyUserCreation() throws IOException {
	  
	  String userName = ExcelUtility.getStringData(1, 0, "AdminUserPageTest");
	  String password = ExcelUtility.getStringData(1, 1, "AdminUserPageTest");
	 // String infoUserName = ExcelUtility.getStringData(1, 4, "AdminUserPageTest");
	  //String infoPassword = ExcelUtility.getStringData(1, 3, "AdminUserPageTest");
	  String infoUserName = fakerutility.getFakeFirstName();
	  String infoPassword = fakerutility.getPassword();
	  String userType = ExcelUtility.getStringData(1, 2, "AdminUserPageTest");
	  
	  LoginPage loginpage = new LoginPage(driver);
	  
	  loginpage.enterUsernameAndPassword(userName,password);
	  
	  homepage=loginpage.clickSignIn();
	  
	  /*AdminUserPage adminuserpage = new AdminUserPage(driver);
	  
	  adminuserpage.clickAdminUserMoreInfo();
	  
	  adminuserpage.clickAdminUserNewButton();
	  
	  adminuserpage.enterAdminUserInfoUserName(infoUserName);
	  
	  adminuserpage.enterAdminUserInfoPassword(infoPassword);
	  
	  adminuserpage.selectAdminUserType(userType);
	  
	  adminuserpage.clickAdminUserSaveBtn();*/
	  
	  adminuserpage = homepage.clickAdminUserMoreInfo();
	  
	  adminuserpage.clickAdminUserNewButton().enterAdminUserInfoUserName(infoUserName).enterAdminUserInfoPassword(infoPassword).selectAdminUserType(userType).clickAdminUserSaveBtn();
	  
	  Assert.assertTrue(adminuserpage.userCreatedSuccessfullyMsgIsDisplayed(), Constants.ERRORCREATEUSER);
	    
  }
}
