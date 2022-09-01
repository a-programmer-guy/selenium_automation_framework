package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	public static void main(String[] args) throws IOException {
		// Read the config.properties file
		try {

			FileReader reader = new FileReader("/home/kay/Desktop/projects/selenium_automation_framework"
					+ "/src/test/resources/configfiles/config.properties");
			// Create properties object
			Properties properties = new Properties();

			// Load the config.properties file
			properties.load(reader);

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
