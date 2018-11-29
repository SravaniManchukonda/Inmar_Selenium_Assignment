package tests;

import java.lang.reflect.Method;
import java.util.List;
import generic.Variables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pages.GenericPage;
import generic.Log;

public class HTMLTags extends GenericPage{
	public WebDriver driver;
	@Test
	public void links(Method method) throws InterruptedException{
		
		Log.info(this.getClass().getSimpleName(),method.getName(), "Test Case Execution Started");
		//Launch Browser and navigate to url
		driver = launchBrowser(Variables.driver_name, driver, Variables.driver_path);
		navigateToURL(driver,Variables.selenium_practise_url);
		
		//List and print all web links
		List<WebElement> html_tags = driver.findElements(By.tagName("a"));
		for(WebElement tag:html_tags){
			System.out.println(tag.getAttribute("href"));
			Log.info(this.getClass().getSimpleName(),method.getName(), "Html Links Found : "+tag.getAttribute("href"));
		}
		driver.close();
		Log.info(this.getClass().getSimpleName(),method.getName(), "Test Case Execution Completed");
		
	}
	 @AfterMethod
	  public void afterMethod(ITestResult result,Method method) throws InterruptedException {
		 exceptionHandling(driver, result);
		 Log.info(this.getClass().getSimpleName(), method.getName(), "Test Case Execution Completed");
	  }
}
