package testscriptPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageUserPage;
import utilities.ExcelUtility;

public class ManageUserPageTest extends Base{
	
	ManageUserPage manageuserpage;
	
	HomePage homepage;
	
  @Test
  public void createNews() throws IOException {
	  
	  String userName = ExcelUtility.getStringData(1, 0, "ManageUserPageTest");
	  String password = ExcelUtility.getStringData(1, 1, "ManageUserPageTest");
	  String news = ExcelUtility.getStringData(1, 2, "ManageUserPageTest");
	  
	  
	  LoginPage loginpage = new LoginPage(driver);
	  
	  loginpage.enterUsernameAndPassword(userName,password);
	  
	  homepage=loginpage.clickSignIn();
	  
	  manageuserpage = homepage.clickManageNewsInfo();
	  
	  manageuserpage.clickManageNewsNewBtn().enterManageNewsEnterTheNews(news).clickManageNewsSaveBtn();
	  
	  /*ManageUserPage manageuserpage = new ManageUserPage(driver);
	  
	  manageuserpage.clickManageNewsInfo();
	  
	  manageuserpage.clickManageNewsNewBtn();
	  
	  manageuserpage.enterManageNewsEnterTheNews(news);
	  
	  manageuserpage.clickManageNewsSaveBtn();*/
	  
	  Assert.assertTrue(manageuserpage.isDisplayedManageNewsSuccessfulAlert(), Constants.ERRORCREATENEWS);
  }
}
