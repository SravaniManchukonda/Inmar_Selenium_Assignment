package tests;

import java.lang.reflect.Method;

import generic.Log;
import generic.Variables;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pages.GenericPage;

public class Title extends GenericPage{
	public WebDriver driver;
	@Test
	public void title(Method method) throws InterruptedException{
		Log.info(this.getClass().getSimpleName(),"", "Test Case Execution Started");
		//Launch Browser and navigate to url
		driver = launchBrowser(Variables.driver_name, driver, Variables.driver_path);
		navigateToURL(driver,Variables.inmar_url);
		System.out.println("Title of the page is "+driver.getTitle());
		Log.info(this.getClass().getSimpleName(),"", "Title of the page is "+driver.getTitle());
		driver.close();
		Log.info(this.getClass().getSimpleName(),method.getName(), "Test Case Execution Completed");
	}@AfterMethod
	  public void afterMethod(ITestResult result,Method method) throws InterruptedException {
		 exceptionHandling(driver, result);
		 Log.info(this.getClass().getSimpleName(), method.getName(), "Test Case Execution Completed");
	  }
}
