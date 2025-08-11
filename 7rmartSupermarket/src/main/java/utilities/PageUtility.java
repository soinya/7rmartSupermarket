package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	//Select By Value
	public void selectByValue(WebElement ele,String value) {
		Select select = new Select(ele);
		
		select.selectByValue(value);
	}

	//Select By Index
	public void selectByIndex(WebElement ele,int index) {
		Select select = new Select(ele);
		
		select.selectByIndex(index);
	}
	
	//Select By Visible Text
	public void selectByVisibleText(WebElement ele,String text) {
		Select select = new Select(ele);
		
		select.selectByVisibleText(text);
	}
	
	
	//Drag & Drop
	
	public void dragAndDrop(WebDriver driver,WebElement source, WebElement target) {
		
		Actions actions = new Actions(driver);
		
		//actions.moveToElement(drop).click().perform();
		
		actions.dragAndDrop(source, target).build().perform();
	}
	
	//Scroll
	
	public void scrollMethod(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
	}
	
}
