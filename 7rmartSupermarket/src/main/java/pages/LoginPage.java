package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	
	WaitUtility waitutility = new WaitUtility();

	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	//UserName
	@FindBy(xpath ="//input[@name='username']") WebElement userName;
	
	//Password
	@FindBy(xpath = "//input[@name='password']")WebElement password;
	
	//RememberMe
	@FindBy(xpath ="//label[@for='remember']")WebElement rememberMe;
	
	//Sign In
	@FindBy(xpath="//button[text()='Sign In']")WebElement signIn;
	
	//Dashboard
	@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboard;
	
	//Alert InValid credentials
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement alertInvalidCredentials;
	
	public LoginPage enterUsernameAndPassword(String username, String passWord) {
		userName.sendKeys(username);
		password.sendKeys(passWord);
		return this;
	}
	
	public LoginPage clickRememberMe() {
		rememberMe.click();
		return this;
	}
	
	public HomePage clickSignIn() {
		waitutility.waitforElementToClick(driver, signIn);
		signIn.click();
		return new HomePage(driver);
	}
	
	public boolean dashboardIsDisplayed() {
		return dashboard.isDisplayed();
	}
	
	public boolean alertInvalidCredentialsIsDiaplayed() {
		return alertInvalidCredentials.isDisplayed();
	}

}
