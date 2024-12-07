package design.pattern.Factory.Object.Pool;

import java.util.logging.Logger;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser implements Browser {
	private static final Logger logger = Logger.getLogger(ChromeBrowser.class.getName());

	@Override
	public WebDriver launchBrowser(Capabilities capabilities) {
		ChromeOptions options;
		if (capabilities instanceof ChromeOptions) {
			options = (ChromeOptions) capabilities;
		} else {
			// send default chrome options
			options = new ChromeOptions();
			logger.warning("The provided chrome options were not compitable, hence rest to default");

		}
		/**
		 * if i user driver.get(url) we have to define in every class like firefox,edge etc 
		 */
//		WebDriver driver = new ChromeDriver(options);
//		driver.get(url);
//		return driver;
//		
		logger.info("The Chrome browser is launched with capabalities");
		return new ChromeDriver(options);
	}

}
