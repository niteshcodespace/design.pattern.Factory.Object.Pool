package design.pattern.Factory.Object.Pool;

import java.util.logging.Logger;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxBrowser implements Browser {
	private static final Logger logger = Logger.getLogger(FirefoxBrowser.class.getName());

	@Override
	public WebDriver launchBrowser(Capabilities capabilities) {
		FirefoxOptions options;
		if (capabilities instanceof FirefoxOptions) {
			options = (FirefoxOptions) capabilities;
		} else {
			// send default chrome options
			options = new FirefoxOptions();
			logger.warning("The provided Firefox options were not compitable, hence rest to default");

		}

		logger.info("The Firefox browser is launched with capabalities");
		return new FirefoxDriver(options);
	}

}
