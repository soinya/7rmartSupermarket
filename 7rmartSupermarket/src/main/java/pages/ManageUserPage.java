package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageUserPage {

	WebDriver driver;
	
	public ManageUserPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement manageNewsNewBtn;
	
	@FindBy(xpath="//textarea[@id='news']") WebElement manageNewsEnterTheNews;
	
	@FindBy(xpath="//button[@type='submit']") WebElement manageNewsSaveBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement manageNewsSuccessfulAlert;
	
	//Search btn
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']") WebElement manageNewsSearchBtn;
	
	//Search_news
	@FindBy(xpath="//input[@name='un']") WebElement searchNewsText;
	
	//Search ManageNews_Search
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")WebElement searchManageNewsSearch;
	
	//Search_FirstNews
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody/tr[1]/td[1]") WebElement searchFirstNews;
	
	//Search_deleteFirstNews
	@FindBy(xpath="(//a[@class='btn btn-sm btn btn-danger btncss'])[1]") WebElement searchNewsDelete;
	
	//News Deleted Msg
	@FindBy(xpath="//div[text()[normalize-space()='News Deleted Successfully']]") WebElement newsDeletedMsg;
	
	public ManageUserPage clickManageNewsNewBtn() {
		manageNewsNewBtn.click();
		return this;
	}
	
	public ManageUserPage enterManageNewsEnterTheNews(String news) {
		manageNewsEnterTheNews.sendKeys(news);
		return this;
	}
	
	public ManageUserPage clickManageNewsSaveBtn() {
		manageNewsSaveBtn.click();
		return this;
	}
	
	public boolean isDisplayedManageNewsSuccessfulAlert() {
		return manageNewsSuccessfulAlert.isDisplayed();
	}
	
	public ManageUserPage clickManageNewsSearchBtn() {
		manageNewsSearchBtn.click();
		return this;
	}
	
	public ManageUserPage enterManageNewsSearchNewsText(String news) {
		searchNewsText.sendKeys(news);
		return this;
	}
	
	public ManageUserPage clickSearchManageNewsSearchBtn() {
		searchManageNewsSearch.click();
		return this;
	}
	
	public String getTextSearchFirstNews() {
		return searchFirstNews.getText();
	}
	
	public ManageUserPage clickSearchNewsDeleteBtn() {
		searchNewsDelete.click();
		return this;
	}
	
	public boolean isDisplayedManageNewsDeletedMsg() {
		return newsDeletedMsg.isDisplayed();
	}
	
}
