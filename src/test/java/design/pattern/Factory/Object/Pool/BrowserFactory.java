package design.pattern.Factory.Object.Pool;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

//import design.patterns.factory.browser.BrowserTypes;
import design.pattern.Factory.Object.Pool.BrowserTypes;
//import design.patterns.factory.browser.WebDriverFactory;
import design.pattern.Factory.Object.Pool.WebDriverFactory;

public class BrowserFactory {

	public static void main(String[] args) {
		WebDriverFactory factory = new WebDriverFactory();
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		factory.createDriver(BrowserTypes.CHROME, chromeOptions);
		factory.setupDriver("");
		
		
		FirefoxOptions firfoxOptions= new FirefoxOptions();
		firfoxOptions.addArguments("--headless");
		factory.createDriver(BrowserTypes.FIREFOX, firfoxOptions);
		factory.setupDriver("");
		
		
		EdgeOptions edgeOptions = new EdgeOptions();
		edgeOptions.addArguments("headed");
		factory.createDriver(BrowserTypes.EDGE, edgeOptions);
		
	}
}
