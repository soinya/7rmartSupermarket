package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageCategoryPage {
	
	WebDriver driver;
	
	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	//ListCategory_New btn
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement listCategoryNewBtn;
	
	//AddCategory_EnterTheCategory
	@FindBy(xpath="//input[@id='category']")WebElement addCategoryEnterCategory;
	
	//Select Groups
	@FindBy(xpath="//li[@id='134-selectable']/span")WebElement addCategorySelectGroups;
	
	//Choose File
	@FindBy(xpath="//input[@id='main_img']")WebElement addCategoryChooseFile;
	
	public ManageCategoryPage clickListCategoryNewBtn() {
		listCategoryNewBtn.click();
		return this;
	}
	
	public ManageCategoryPage enterAddCategoryEnterCategory(String category) {
		addCategoryEnterCategory.sendKeys(category);;
		return this;
	}
	
	public ManageCategoryPage clickAddCategorySelectGroups() {
		addCategorySelectGroups.click();
		return this;
	}
	
	public ManageCategoryPage clickAddCategoryChooseFile(String path) {
		addCategoryChooseFile.sendKeys(path);;
		return this;
	}
	
	
					

}
