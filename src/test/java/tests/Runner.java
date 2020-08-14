package tests;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import pages.FormsTab;
import pages.SwipeTab;
import pages.WebViewTab;
import utilities.TestUtility;

public class Runner
{	
	public AndroidDriver<AndroidElement> driver;	
	public WebDriverWait w;
	public TouchAction ta;
	public Properties p;
	public TestUtility tu;
	
	@BeforeTest
	public void startExecution() throws Exception
	{
		File f=new File("D:\\AppiumFolder\\com.appsierra.mobiledevelopment\\src\\test\\java\\properties\\data.properties");
		FileInputStream fi=new FileInputStream(f);
		p=new Properties();
		p.load(fi);		
		tu=new TestUtility();
		URL u=tu.startAppiumServer();		
		DesiredCapabilities dc=tu.defineDesiredCapabilities(p);
		driver = new AndroidDriver<AndroidElement>(u, dc);
	}
		
	@Test(priority=1)
	public void sumbitForm() throws Exception
	{
		FormsTab ft=new FormsTab(driver);
		w=new WebDriverWait(driver,60);
		w.until(ExpectedConditions.visibilityOf(ft.formsText));
		ft.clickOnFormsTab();
		w.until(ExpectedConditions.visibilityOf(ft.textbox));
		ft.fillTextbox("Hi");
		driver.hideKeyboard();
		ft.turnOnSwitch();
		ft.clickOnDropdown();
		w.until(ExpectedConditions.visibilityOf(ft.item));
		ft.clickAnItem();
		w.until(ExpectedConditions.visibilityOf(ft.activebutton));
		ft.clickOnActiveButton();
		w.until(ExpectedConditions.visibilityOf(ft.okbutton));
		ft.clickOk();		
	}
	
	@Test(priority=2)
	public void swipeToLast()
	{
		SwipeTab st=new SwipeTab(driver);
		w.until(ExpectedConditions.visibilityOf(st.swipeText));
		st.clickOnSwipeTab();
		w.until(ExpectedConditions.visibilityOf(st.firstElement));
		st.swipe();
	}
	
	@Test(priority=3)
	public void scrollToBottom()
	{
		WebViewTab wt=new WebViewTab(driver);
		w.until(ExpectedConditions.visibilityOf(wt.webviewText));
		wt.clickOnWebViewTab();
		w.until(ExpectedConditions.visibilityOf(wt.webdriveriotext));
		wt.scroll();	 	
	}	
	
	@AfterTest
	public void stopExecution() throws Exception
	{
		tu.closeapp(driver);
		tu.stopAppiumServer();
	}	
}
