import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumDemo {

    // RUN THIS COMMAND IN TERMINAL W/ CHROME DISPLAYED ON EMULATOR: adb shell dumpsys window | grep -E 'mCurrentFocus'

    /*
    Go to Google
    Search for TechGlobal
    */
    @Test
    public void demo1() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();

        //caps.setCapability("platformName", "android");
        //caps.setCapability("deviceName", "pixel_4_2");
        //caps.setCapability("browser", "chrome");
        caps.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, "android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "pixel_4_29");
        caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");

        // com.android.chrome/com.google.android.apps.chrome.Main
        //caps.setCapability("appPackage", "com.android.chrome");
        //caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");

        URL url = new URL("http://127.0.0.1:4723/wd/hub/");
        WebDriver driver = new RemoteWebDriver(url, caps);

        //AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url, caps);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //driver.findElementById("com.android.chrome:id/search_box_text").sendKeys("TechGlobal");

        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("TechGlobal", Keys.ENTER);

        Thread.sleep(10000);
    }

    //BROWSER TESTING FOR WEB APPLICATION BUT ON MOBILE DEVICES
    //WebDriver driver = new RemoteWebDriver(url, caps);

        //driver.get("https://www.carvana.com");

    //driver.findElement(By.name("q")).sendKeys("TechGlobal" + Keys.ENTER);

       // Thread.sleep(10000);
}
