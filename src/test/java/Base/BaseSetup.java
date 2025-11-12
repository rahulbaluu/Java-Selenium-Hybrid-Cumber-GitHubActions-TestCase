package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseSetup {
	protected static WebDriver driver;

	public BaseSetup(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void navigateTo(String url) {
		driver.get(url);
	}
}
