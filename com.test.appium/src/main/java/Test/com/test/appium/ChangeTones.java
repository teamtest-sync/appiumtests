package Test.com.test.appium;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.verizon.utility.APIConstants;
import com.verizon.utility.ConfiguredCapabilities;
import com.verizon.utility.HandlerUtility;

import io.appium.java_client.android.AndroidDriver;

public class ChangeTones {

	AndroidDriver driver;
	ConfiguredCapabilities loadedCapabilities;

	@Test
	public void changeTone() {
		WebElement convGalleryOption = driver.findElementById(loadedCapabilities.getIMGCONVGALLERYOPTION());
		convGalleryOption.click();

		WebElement customizeMenuBtn = driver.findElementByName("Customize");
		customizeMenuBtn.click();

		WebElement tonesOption = driver.findElementByName("Tones");
		tonesOption.click();

		// Select a tone from the list
		List<WebElement> toneList = driver.findElementsById(loadedCapabilities.getTEXT1());
		toneList.get(5).click();

		WebElement selectOKButton = driver.findElementById(loadedCapabilities.getBUTTON1());
		selectOKButton.click();

	}

	@BeforeClass
	public void setUp() throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		loadedCapabilities = HandlerUtility.getCapabilities();
		capabilities.setCapability(APIConstants.DEVICE, loadedCapabilities.getDEVICE());
		capabilities.setCapability(APIConstants.PLATFORMNAME, loadedCapabilities.getPLATFORM_NAME());
		capabilities.setCapability(APIConstants.DEVICENAME, loadedCapabilities.getDEVICE_NAME());
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability(CapabilityType.VERSION, loadedCapabilities.getVERSION());
		capabilities.setCapability(CapabilityType.PLATFORM, loadedCapabilities.getPLATFORM());
		capabilities.setCapability(APIConstants.NORESET, loadedCapabilities.getNORESET());

		capabilities.setCapability(APIConstants.APP, loadedCapabilities.getFILE_PATH());
		capabilities.setCapability(APIConstants.APP_PACKAGE, loadedCapabilities.getAPP_PACKAGE());
		capabilities.setCapability(APIConstants.APP_ACTIVITY, loadedCapabilities.getAPP_ACTIVITY());
		driver = new AndroidDriver(new URL(loadedCapabilities.getURL()), capabilities);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
