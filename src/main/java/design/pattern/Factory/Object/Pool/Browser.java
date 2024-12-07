package design.pattern.Factory.Object.Pool;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

public interface Browser {
	/**
	 * Launches the browser with specific URL and capablilites
	 * @param capabilities The desired capabilites of the browser 
	 * @return The instance of the browser as WebDriver
	 * @author Nitesh
	 * @since v1.1
	 */
	
	WebDriver launchBrowser(Capabilities capabilities);
		
		// we are uing dependecies Inversion multiple Interface 


}
