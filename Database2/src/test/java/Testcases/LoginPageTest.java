package Testcases;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import page.DatabasePage;
import page.LoginPage;

public class LoginPageTest extends TestBase {
	
  LoginPage loginpageObj;
	@BeforeMethod
	public void setup() {
		initializeDriver();
	
		loginpageObj = PageFactory.initElements(driver, LoginPage.class);
	}
		@Test(priority=1)
		public void LoginTest() throws InterruptedException, ClassNotFoundException, SQLException, IOException {
		
		loginpageObj.enterUserName("demo@techfios.com");
		Thread.sleep(2000);
		loginpageObj.enterPassword("abc123");
		Thread.sleep(2000);
		loginpageObj.clickOnSignInButton();
		
		takeScreenshotAtEndOfTest(driver);
		}
		
		@Test(priority=1)
		
		public void LoginTestTitleTest() throws InterruptedException, ClassNotFoundException, SQLException {
		
		loginpageObj.enterUserName("demo@techfios.com");
		Thread.sleep(2000);
		loginpageObj.enterPassword("abc123");
		Thread.sleep(2000);
		loginpageObj.clickOnSignInButton();
		String expectedTitle = "Dashboard- iBilling";
		String actualTitle = loginpageObj.getPageTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		

	}
	
	 @AfterMethod
	 public void tearDown() {  
	  driver.close();
	  driver.quit();
	 }
	
}