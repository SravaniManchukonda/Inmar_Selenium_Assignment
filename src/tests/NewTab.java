package tests;

import java.lang.reflect.Method;
import java.util.Set;

import generic.Log;
import generic.Variables;
import pages.GenericPage;
import pages.SeleniumPractisePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class NewTab extends GenericPage{
	public WebDriver driver;
	SeleniumPractisePage se = new SeleniumPractisePage();
	
	@Test
	public void newTab(Method method) throws InterruptedException{
		Log.info(this.getClass().getSimpleName(),"", "Test Case Execution Started");
		//Launch Browser and navigate to url
		driver = launchBrowser(Variables.driver_name, driver, Variables.driver_path);
		navigateToURL(driver,Variables.selenium_practise_url);
		
		String mainwindow = driver.getWindowHandle();
		//List and print all web links
		se.newBrowserTab(driver).click();
		Set<String> windowhandles = driver.getWindowHandles();
		for(String handle:windowhandles){
			if(!(handle.equalsIgnoreCase(mainwindow))){
				
				// switch to new window
				driver.switchTo().window(handle);
				System.out.println("New Window title is "+driver.getTitle());
				Log.info(this.getClass().getSimpleName(),method.getName(), "New Window title is "+driver.getTitle());
				
				//verify both windows are present and print title
				driver.switchTo().window(mainwindow);
				System.out.println("Main Window title is "+driver.getTitle());
				Log.info(this.getClass().getSimpleName(),method.getName(), "Main Window title is "+driver.getTitle());
				driver.switchTo().window(handle);
				System.out.println("New Window title is "+driver.getTitle());
				Log.info(this.getClass().getSimpleName(),method.getName(), "New Window title is "+driver.getTitle());
				
				driver.close();
			}
		}

		driver.switchTo().window(mainwindow);
	
		driver.close();
		Log.info(this.getClass().getSimpleName(),method.getName(), "Test Case Execution Completed");
	}@AfterMethod
	  public void afterMethod(ITestResult result,Method method) throws InterruptedException {
		 exceptionHandling(driver, result);
		 Log.info(this.getClass().getSimpleName(), method.getName(), "Test Case Execution Completed");
	  }
}
