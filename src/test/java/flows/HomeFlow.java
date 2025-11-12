package flows;

import Base.BaseSetup;
import constant.HomePageConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeFlow extends BaseSetup {
	public HomeFlow(WebDriver driver) {
		super(driver);
	}

	public void clickOnSignupButton() {
		driver.findElement(By.linkText(HomePageConstant.signupLoginButton)).click();
	}
}
