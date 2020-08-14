package pages;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WebViewTab 
{
	public AndroidDriver<AndroidElement> driver;
	public TouchAction ta;
	
	@AndroidFindBy(xpath="//*[@text='WebView']")
	public AndroidElement webviewText;
	
	@AndroidFindBy(xpath="//*[@text='WEBDRIVER I/O']")
	public AndroidElement webdriveriotext;
	
	@AndroidFindBy(xpath="//*[contains(@text,'Copyright © 2020')]")
	public AndroidElement bottomElement; 		
	
	public WebViewTab(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	public void clickOnWebViewTab()
	{
		webviewText.click();
	}
	
	public void scroll()
	{		    
		ta=new TouchAction(driver);	
		int wt=driver.manage().window().getSize().getWidth();
	    int ht=driver.manage().window().getSize().getHeight();
		int x1=(int)(wt/2);
	    int y1=(int)(ht*0.9);
	    int x2=(int)(wt/2);
	    int y2=(int)(ht*0.5);
	    while(2>1)
	    {
	    	try
		    {
			    bottomElement.isDisplayed(); 
			    Reporter.log("We are at the bottom of the screen");
			    break;
		    }
		    catch(Exception e)
		    {			
		    	PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH,"finger");
				Sequence s=new Sequence(finger,1);
				s.addAction(finger.createPointerMove(Duration.ofMillis(0),PointerInput.Origin.viewport(),x1,y1));
				s.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
				s.addAction(finger.createPointerMove(Duration.ofMillis(50),PointerInput.Origin.viewport(),x2,y2));
				s.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
				driver.perform(Arrays.asList(s));
		    }
	    }
	}
}
