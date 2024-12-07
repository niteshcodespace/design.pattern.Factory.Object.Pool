package design.pattern.Factory.Object.Pool;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import net.bytebuddy.asm.Advice.ArgumentHandler.Factory;

public class WebDriverFactoryObjectPoolTest {

	private static final Logger logger = Logger.getLogger(WebDriverFactoryObjectPoolTest.class.getName());

	public static void main(String[] args) {

		// initialize the factory
		WebDriverFactory factory = new WebDriverFactory();

		// initialize the Object pool
		WebDriverPoolFactory pool = new WebDriverPoolFactory(factory);

		// Applications
		String url1 = "https://google.com";
		String url2 = "https://testleaf.com";

		// chromeOptions
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");

		// firefoxOptions
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.addArguments("--headed");

		// test1 >> chrome >> url1
		// test1 >> chrome >> url2
		// test1 >> firefox >> url1
		// test1 >> firefox >> url2

		test1(pool, BrowserTypes.CHROME, url1, chromeOptions);
		test2(pool, BrowserTypes.CHROME, url2, chromeOptions);
		test3(pool, BrowserTypes.FIREFOX, url1, firefoxOptions);
		test4(pool, BrowserTypes.FIREFOX, url2, firefoxOptions);

	}

	private static void test1(WebDriverPoolFactory pool, BrowserTypes browser, String url1,
			ChromeOptions chromeOptions) {
		logger.info("The Test 1 is started");
		WebDriver driver = pool.getDriver(browser,url1, chromeOptions);
		//fatory.setUp
		logger.info("Title >>" + driver.getTitle());
		pool.releaseDriver(driver);
		logger.info("The Test 1 is completed");

	}

	private static void test2(WebDriverPoolFactory pool, BrowserTypes browser, String url2,
			ChromeOptions chromeOptions) {
		logger.info("The Test 2 is started");
		WebDriver driver = pool.getDriver(browser,url2, chromeOptions);
		logger.info("Title >>" + driver.getTitle());
		pool.releaseDriver(driver);
		logger.info("The Test 2 is completed");

	}

	private static void test3(WebDriverPoolFactory pool, BrowserTypes browser, String url1,
			FirefoxOptions firefoxOptions) {
		logger.info("The Test 3 is started");
		WebDriver driver = pool.getDriver(browser,url1, firefoxOptions);
		logger.info("Title >>" + driver.getTitle());
		pool.releaseDriver(driver);
		logger.info("The Test 3 is completed");

	}

	private static void test4(WebDriverPoolFactory pool, BrowserTypes browser, String url2,
			FirefoxOptions firefoxOptions) {
		logger.info("The Test 4 is started");
		WebDriver driver = pool.getDriver(browser ,url2, firefoxOptions);
		logger.info("Title >>" + driver.getTitle());
		pool.releaseDriver(driver);
		logger.info("The Test 4 is completed");

	}

}
