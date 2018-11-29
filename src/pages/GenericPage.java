package pages;


import generic.Variables;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GenericPage {
	public WebDriver launchBrowser(String driver_name ,WebDriver driver,String driver_path) throws InterruptedException {
		
		switch(driver_name){
			case "Chrome": 
				System.setProperty("webdriver.chrome.driver", driver_path);
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--start-maximized");
				chromeOptions.addArguments("--disable-notifications");
				driver= new ChromeDriver(chromeOptions);
				break;
			case "Gecko": 
				System.setProperty("webdriver.gecko.driver", driver_path);
				driver= new FirefoxDriver();
				break;
		}
		return driver;
	}
	public WebDriver navigateToURL(WebDriver driver,String url){
		driver.navigate().to(url);
		return driver;
	}
	public void WaitForElementVisibilityByLocator(WebDriver driver,By locator,int Timeout){
		//Explicit Wait
		WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver,Timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public void waitForPageLoaded(WebDriver driver) {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
	public static void captureScreenshot(WebDriver driver,String screenshotName)
	{
	try 
	{
	File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	
	FileUtils.copyFile(screenshotFile, new File(Variables.SCREENSHOTS_PATH+screenshotName+"\\Screenshot"+ System.currentTimeMillis() + ".png"));
	 
	System.out.println("Screenshot taken");
	} 
	
	catch (Exception e)
	{
	 
	System.out.println("Exception while taking screenshot "+e.getMessage());
	} 
	
	}
	
	public void exceptionHandling(WebDriver driver,ITestResult result) throws InterruptedException{
		 if(ITestResult.FAILURE == result.getStatus()){
			 System.out.println("entered exception handling"); 
			 String screenshot_name = result.getTestClass().getRealClass().getSimpleName()+"."+result.getMethod().getMethodName();
			  captureScreenshot(driver,screenshot_name);
		  }
		  
	}
	
}
