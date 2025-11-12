package stepDefenition;

import Base.BaseSetup;
import flows.*;
import org.openqa.selenium.WebDriver;
import utilities.DriverSetup;
import utilities.ExcelUtils;

public class BaseStepDef {
	protected WebDriver driver;
	protected ExcelUtils excelUtils;
	protected BaseSetup baseSetup;
	protected CartFlow cartFlow;
	protected HomeFlow homeFlow;
	protected LoginFlow loginFlow;
	protected ProductFlow productFlow;
	protected RegistrationFlow registrationFlow;
	protected SignupLoginFlow signupLoginFlow;

	public BaseStepDef() {
		this.driver = DriverSetup.getDriver();

		this.baseSetup = new BaseSetup(driver);
		this.cartFlow = new CartFlow(driver);
		this.homeFlow = new HomeFlow(driver);
		this.loginFlow = new LoginFlow(driver);
		this.productFlow = new ProductFlow(driver);
		this.registrationFlow = new RegistrationFlow(driver);
		this.signupLoginFlow = new SignupLoginFlow(driver);
	}

	public void loadExcel(String sheetName) throws Exception {
		excelUtils = new ExcelUtils();
		ExcelUtils.setExcelFile("src/test/resources/TestData.xlsx", sheetName);
	}
}
