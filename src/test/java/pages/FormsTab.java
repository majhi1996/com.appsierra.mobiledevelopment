package pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormsTab 
{
	public AndroidDriver<AndroidElement> driver;
	
	@AndroidFindBy(xpath="//*[@text='Forms']")
	public AndroidElement formsText;
	
	@AndroidFindBy(xpath="//*[@text='Type something']")
	public AndroidElement textbox;
	
	@AndroidFindBy(xpath="//*[@text='OFF' or @text='ON']")
	public AndroidElement togglebutton; 	
	
	@AndroidFindBy(xpath="//*[@text='Select a value here']")
	public AndroidElement dropdown;
	
	//Selecting 2nd list as of now
	@AndroidFindBy(xpath="//*[@text='Appium is awesome']")
	public AndroidElement item;	
	
	@AndroidFindBy(xpath="//*[@text='Active']")
	public AndroidElement activebutton;
	
	@AndroidFindBy(xpath="//*[@text='OK']")
	public AndroidElement okbutton;
	
	
	public FormsTab(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void clickOnFormsTab()
	{
		formsText.click();
	}
	
	public void fillTextbox(String x)
	{
		textbox.sendKeys(x);
	}
	
	public void turnOnSwitch()
	{
		togglebutton.click();
	}
	
	public void clickOnDropdown()
	{
		dropdown.click();		
	}
	
	public void clickAnItem()
	{
		item.click();
	}
	
	public void clickOnActiveButton()
	{
		activebutton.click();
	}
	
	public void clickOk()
	{
		okbutton.click();
	}
}
