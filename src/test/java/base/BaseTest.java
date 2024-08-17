package base;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import config.ConfigReader;

public class BaseTest {

	private static Properties prop;
	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
	public static WebDriver getDriver() {
		return threadDriver.get();
	}
	@BeforeTest
	public void setUp() throws IOException {
		prop = ConfigReader.getPropertyObject();
		String browseName = prop.getProperty("browser");

		if (browseName.equalsIgnoreCase("chrome")) {
			WebDriver driver = new ChromeDriver();
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			threadDriver.set(driver);
		}
	}
	@AfterTest
	public void tearDown() {
		if (getDriver() != null) {
			getDriver().quit();
		}
		threadDriver.remove();
	}

}
