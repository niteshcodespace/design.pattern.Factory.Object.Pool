package design.pattern.Factory.Object.Pool;

import java.util.logging.Logger;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class EdgeBrowser implements Browser {
	private static final Logger logger = Logger.getLogger(EdgeBrowser.class.getName());

	@Override
	public WebDriver launchBrowser(Capabilities capabilities) {
		EdgeOptions options;
		if (capabilities instanceof EdgeOptions) {
			options = (EdgeOptions) capabilities;
		} else {
			// send default chrome options
			options = new EdgeOptions();
			logger.warning("The provided Edge options were not compitable, hence rest to default");

		}

		logger.info("The Edge browser is launched with capabalities");
		return new EdgeDriver(options);
	}

}
