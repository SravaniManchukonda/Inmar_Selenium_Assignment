package tests;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import generic.Log;
import generic.Variables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pages.GenericPage;
import pages.SeleniumPractisePage;




public class ImplicitExplicitWaits extends GenericPage{
	public WebDriver driver;
	SeleniumPractisePage se = new SeleniumPractisePage();
	
	@Test
	public void title(Method method) throws InterruptedException{
		Log.info(this.getClass().getSimpleName(),method.getName(), "Test Case Execution Started");
		//Launch Browser and navigate to url
		driver = launchBrowser(Variables.driver_name, driver, Variables.driver_path);
		navigateToURL(driver,Variables.selenium_practise_url);
		
		// Implicit wait . Waits for specified time to identify element
		//Implicit works for whole test 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize() ;
		//Here to get the title of page , driver waits for element to be identified till 10 secs
		System.out.println(driver.getTitle());
		Log.info(this.getClass().getSimpleName(),method.getName(), driver.getTitle());
		
		//Explicit wait .Waits for specified time to identify element
		//Explicit works for particular element,where it is used
		se.forumsLink(driver).click();
		Log.info(this.getClass().getSimpleName(),method.getName(), "Explicit Wait.waiting for element facebook forums");
		WebDriverWait wait = new WebDriverWait(driver,1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Facebook Forums")));
		
		driver.close();
		Log.info(this.getClass().getSimpleName(),method.getName(), "Test Case Execution Completed");
	}
	 @AfterMethod
	  public void afterMethod(ITestResult result,Method method) throws InterruptedException {
		 exceptionHandling(driver, result);
		 Log.info(this.getClass().getSimpleName(), method.getName(), "Test Case Execution Completed");
	  }
}
