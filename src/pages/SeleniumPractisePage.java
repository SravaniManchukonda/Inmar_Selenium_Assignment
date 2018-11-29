package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SeleniumPractisePage {

	public WebElement newBrowserTab(WebDriver driver){
		 
		return driver.findElement(By.xpath("//button[text()='New Browser Tab']"));
	    }
	
	public WebElement forumsLink(WebDriver driver){
		return driver.findElement(By.linkText("FORUMS"));
	}
	
	public WebElement facebookForumsLink(WebDriver driver){
		return driver.findElement(By.linkText("Facebook Forums"));
	}
}
