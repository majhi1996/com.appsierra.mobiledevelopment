package utilities;

import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TestUtility 
{
	public AndroidDriver<AndroidElement> driver;
	
	public DesiredCapabilities defineDesiredCapabilities(Properties p)
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName",p.getProperty("devicename"));
		dc.setCapability("platformName",p.getProperty("platformname"));
		dc.setCapability("platformVersion",p.getProperty("platformversion"));		
		dc.setCapability("appPackage",p.getProperty("apppackage"));
		dc.setCapability("appActivity",p.getProperty("appactivity"));
		return dc; 
	}
	
	public URL startAppiumServer() throws Exception
	{
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		return u;
	}
	
	public void stopAppiumServer() throws Exception
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");	
	}
	
	public void closeapp(AndroidDriver<AndroidElement> driver)
	{
		driver.closeApp();
	}
}
