package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@class='nav-item dropdown']//a")
	WebElement adminDropDown;

	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	WebElement logout;

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[2]")
	WebElement adminUserMoreInfo;

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'])[2]")
	WebElement manageNewsInfo;

	// Manage Category_More Ifo
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'])[2]")
	WebElement manageCategoryMoreInfo;

	public AdminUserPage clickAdminUserMoreInfo() {

		adminUserMoreInfo.click();

		return new AdminUserPage(driver);
	}

	public ManageUserPage clickManageNewsInfo() {
		manageNewsInfo.click();
		return new ManageUserPage(driver);
	}
	
	public ManageCategoryPage clickManageCategoryMoreInfo() {
		manageCategoryMoreInfo.click();
		return new ManageCategoryPage(driver);
	}	

	public HomePage clickAdminDropDown() {
		adminDropDown.click();

		return this;
	}

	public HomePage clickLogout() {
		logout.click();
		return this;
	}

}
