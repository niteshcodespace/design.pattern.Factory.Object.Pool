package design.pattern.Factory.Object.Pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.logging.Logger;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

public class WebDriverPoolFactory {
	private static final Logger logger = Logger.getLogger(WebDriverPoolFactory.class.getName());

	// Factory Object for Browser factory
	private WebDriverFactoryInterface driverFactory;

	// Store the Browser Type and Queue
	private ConcurrentMap<BrowserTypes, BlockingQueue<WebDriver>> driverPool;

	// Map to track: WebDriver, Browser Type
	private ConcurrentMap<WebDriver, BrowserTypes> driverToBrowserKey;

	// constructor
	public WebDriverPoolFactory(WebDriverFactoryInterface factory) {
		this.driverFactory=factory;
	//driverFactory = new WebDriverFactory();
		driverPool = new ConcurrentHashMap<BrowserTypes, BlockingQueue<WebDriver>>();
		driverToBrowserKey = new ConcurrentHashMap<WebDriver, BrowserTypes>();

		// for each browserType create new blocking queue
		for (BrowserTypes browserTypes : BrowserTypes.values()) {
			driverPool.put(browserTypes, new LinkedBlockingDeque<WebDriver>());
		}
	}

	public WebDriver getDriver(BrowserTypes browserType,String url, Capabilities capabilities) {
		BlockingQueue<WebDriver> queue = driverPool.get(browserType);
		WebDriver driver = queue.poll();
		if (driver == null) {
			driver = driverFactory.createDriver(browserType, capabilities);
			//driver = driverFactory.createDriver(browserType, capabilities);
			driverToBrowserKey.put(driver, browserType);
			logger.info("The Driver did not exists before." + driver.hashCode() + "Addded in the map after creating");
		} else {
			logger.info("Reusing the existing driver " + driver.hashCode());
		}
	   driverFactory.setupDriver(url);
		return driver;
	}

	public void releaseDriver(WebDriver driver) {
		BrowserTypes browserTypes = driverToBrowserKey.get(driver);
		if (browserTypes != null) {
			BlockingQueue<WebDriver> queue = driverPool.get(browserTypes);
			queue.offer(driver);
		} else {
			driver.quit();
			logger.warning("Could not find the browser tpye"+ browserTypes + "hence quit the browser");

		}

	}
}
