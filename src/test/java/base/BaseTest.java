package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	/*
	 * Create WebDriver, Properties and FileReader objects that will be used in our
	 * tests. Make them public so they can be accessed outside of this
	 * class/package. Use TestNG annotations @BeforeTest and @AfterTest to run setup
	 * and teardown after each test case.
	 * The properties files hold the definitions for the 
	 */
	public static WebDriver driver;
	public static Properties properties = new Properties();
	public static Properties locators =  new Properties();
	public static FileReader prop_reader;
	public static FileReader loc_reader;
	// Get the url for the location of the project base directory 
	public static String projectDirectory = System.getProperty("user.dir");

	@BeforeSuite
	public void setUp() throws IOException {
		if (driver == null) {
			
			// Read in config and locators properties files
			FileReader prop_reader = new FileReader(projectDirectory + "/src/test/resources/configfiles/config.properties");
			FileReader loc_reader = new FileReader(projectDirectory + "/src/test/resources/configfiles/locators.properties");

			// Load the config and locators files 
			properties.load(prop_reader);
			locators.load(loc_reader);
		}
		
		// If the browser value is chrome - set up a chromedriver, etc...
		if (properties.getProperty("browser").equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(properties.getProperty("testurl"));

		} else if (properties.getProperty("browser").equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(properties.getProperty("testurl"));

		} else if (properties.getProperty("browser").equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(properties.getProperty("testurl"));
		}

	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
		System.out.println("-----Teardown Successful-----");

	}

}
