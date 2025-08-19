package testscriptPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageUserPage;
import utilities.ExcelUtility;

public class ManageUserPageDeleteNews extends Base{
	
	ManageUserPage manageuserpage;
	
	HomePage homepage;
	
  @Test
  public void VerifyUserCanDeleteNews() throws IOException {
	  
	  String userName = ExcelUtility.getStringData(1, 0, "ManageUserPageTest");
	  String password = ExcelUtility.getStringData(1, 1, "ManageUserPageTest");
	  String news = ExcelUtility.getStringData(1, 2, "ManageUserPageTest");
	  
	  
	  LoginPage loginpage = new LoginPage(driver);
	  
	  loginpage.enterUsernameAndPassword(userName,password);
	  
	  homepage=loginpage.clickSignIn();
	  
	  manageuserpage = homepage.clickManageNewsInfo();
	  
	  manageuserpage.clickManageNewsSearchBtn().enterManageNewsSearchNewsText(news).clickSearchManageNewsSearchBtn();
	  
      String actual = manageuserpage.getTextSearchFirstNews();
	  
	  Assert.assertEquals(actual, news, Constants.ERRORNEWSLISTED);
	  
	  manageuserpage.clickSearchNewsDeleteBtn();
	  
	  driver.switchTo().alert().accept();
	  
	  Assert.assertTrue(manageuserpage.isDisplayedManageNewsDeletedMsg(), Constants.ERRORDELETENEWS);
  }
}
