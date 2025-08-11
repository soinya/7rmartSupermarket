package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	
	WebDriver driver;
	
	public void waitforElementToClick(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public void waitforElementToBeSelected(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeSelected(ele));
	}
	
	public void waitforVisibilityOfElement(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void waitforElementToClick(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void waitforFrameToBeAvailable(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ele));
	}

}
