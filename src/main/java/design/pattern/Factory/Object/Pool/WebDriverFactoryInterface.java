package design.pattern.Factory.Object.Pool;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

public interface WebDriverFactoryInterface {

  // WebDriver createDriver(BrowserTypes browserTypes,String url,Capabilities capabilities);
	WebDriver createDriver(BrowserTypes browserTypes,Capabilities capabilities);
	void setupDriver(String url);
}
