package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUserPage {
	
	PageUtility pageutility = new PageUtility();

	WebDriver driver;
	
	public AdminUserPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	
	@FindBy(xpath ="//a[@class='btn btn-rounded btn-danger']") WebElement newBtn;
	
	@FindBy(xpath ="//input[@id='username']") WebElement adminUserInfoUsername;
	
	@FindBy(xpath ="//input[@id='password']") WebElement adminUserInfoPassword;
	
	@FindBy(xpath ="//select[@id='user_type']") WebElement adminUserType;
	
	@FindBy(xpath="//button[@name='Create']") WebElement adminUserSaveBtn;
	
	@FindBy(xpath="//div[text()[normalize-space()='User Created Successfully']]") WebElement successfullMsg;
	
	//search
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']") WebElement search;
	
	//Search_UserName
	@FindBy(xpath ="//input[@id='un']") WebElement searchUserName;
	
	//Search_UserType
	@FindBy(xpath="//select[@id='ut']") WebElement searchUserType;
	
	//Search_Search
	@FindBy(xpath ="//button[@name='Search']") WebElement searchSearch;
	
	//Search_firstUser
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]") WebElement searchFirstUserName;
	
	//Search_deleteUser
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']") WebElement searchDeleteUser;
	
	//User Deleted Alert
	@FindBy(xpath="//div[text()[normalize-space()='User Deleted Successfully']]") WebElement userDeletedMsg;
	
	

	
public AdminUserPage clickAdminUserNewButton() {
		
	newBtn.click();
	return this;
	}

	public AdminUserPage enterAdminUserInfoUserName(String username) {
		adminUserInfoUsername.sendKeys(username);
		return this;
	}
	
	public AdminUserPage enterAdminUserInfoPassword(String password) {
		adminUserInfoPassword.sendKeys(password);
		return this;
	}
	
	public AdminUserPage selectAdminUserType(String userType) {
		
		pageutility.selectByValue(adminUserType, userType);
		return this;

	}
	
	public AdminUserPage clickAdminUserSaveBtn() {
		adminUserSaveBtn.click();
		return this;
	}
	
	public boolean userCreatedSuccessfullyMsgIsDisplayed() {
		return successfullMsg.isDisplayed();
	}
	
	public AdminUserPage clickSearch() {
		search.click();
		return this;
	}
	
	public AdminUserPage enterSearchUserName(String username) {
		searchUserName.sendKeys(username);
		return this;
	}
	
	public AdminUserPage selectSearchUserType(String userType) {		
		pageutility.selectByValue(searchUserType, userType);
		return this;

	}
	
	public AdminUserPage clickSearchBtn() {
		searchSearch.click();
		return this;
	}
	
	public AdminUserPage clickSearchDeleteUserBtn() {
		searchDeleteUser.click();
		return this;
	}
	
	public boolean userDeletedSuccessfullyMsgIsDisplayed() {
		return userDeletedMsg.isDisplayed();
	}
	
	public String getTextFirstUserName() {
		return searchFirstUserName.getText();
	}
	

}
