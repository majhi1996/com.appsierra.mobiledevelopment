package pages;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class SwipeTab 
{
	public AndroidDriver<AndroidElement> driver;
	public TouchAction ta;
	
	@AndroidFindBy(xpath="//*[@text='Swipe']")
	public AndroidElement swipeText;
	
	@AndroidFindBy(xpath="//*[@text='FULLY OPEN SOURCE']")
	public AndroidElement firstElement;	
	
	@AndroidFindBy(xpath="//*[@text='COMPATIBLE']")
	public AndroidElement lastElement;	
	
	public SwipeTab(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	public void clickOnSwipeTab()
	{
		swipeText.click();
	}
	
	public void swipe()
	{
		ta=new TouchAction(driver);
		int wt=driver.manage().window().getSize().getWidth();
	    int ht=driver.manage().window().getSize().getHeight();
	    int y1=(int)(ht/2);
	    int x1=(int)(wt*0.8);
	    int y2=(int)(ht/2); 
	    int x2=(int)(wt*0.4);
	    while(2>1)
	    {
		    try
		    {
			    lastElement.isDisplayed(); 
			    Reporter.log("We are at the last card of horizontal swiping");
			    break;
		    }
		    catch(Exception e)
		    {
			    WaitOptions wo=new WaitOptions();
			    wo.withDuration(Duration.ofSeconds(1));
			    ta.press(ElementOption.point(x1,y1)).waitAction(wo).moveTo(ElementOption.point(x2,y2)).release().perform();
		    }
	    }	
	}
}