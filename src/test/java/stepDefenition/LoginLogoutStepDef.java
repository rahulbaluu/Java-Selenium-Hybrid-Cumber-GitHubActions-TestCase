package stepDefenition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginLogoutStepDef extends BaseStepDef {
	String loginUsername;
	String loginPassword;


	@Given("Click Signup Login button")
	public void clickSignupLoginButton() {
		homeFlow.clickOnSignupButton();
	}

	@When("Enter the email {string} and password {string}")
	public void enterTheCorrectEmailAndPassword(String email, String password) {
		this.loginUsername = email;
		this.loginPassword = password;
		signupLoginFlow.enterTheEmailAndPasswordInLoginTextBox(email,password);
	}

	@And("Click the login button")
	public void clickTheLoginButton() {
		signupLoginFlow.clickLoginButton();
	}

	@And("Verify {string}")
	public void verifyLoginAsUsernameIsVisible(String expectedOutcome) {
		loginFlow.verifyUserName(expectedOutcome);
	}

	@And("Enter the incorrect email {string} and password {string}")
	public void enterTheIncorrectEmailAndPassword(String email, String password) {
		this.loginUsername = email;
		this.loginPassword = password;
		signupLoginFlow.enterTheIncorrectEmailAndPasswordInLoginTextBox(email,password);
	}

	@And("Click the Logout button")
	public void clickTheLogoutButton() {
		loginFlow.clickLogoutButton();
	}

	@Then("Verify it is navigated to the login page")
	public void verifyItIsNavigatedToTheLoginPage() {
		signupLoginFlow.verifyLoginSignupPageVisible();
	}

	@Then("Verify error {string} is visible")
	public void verifyErrorYourEmailOrPasswordIsIncorrectIsVisible(String expectedErrorMessage) {
		String actualErrorMessage = signupLoginFlow.getErrorMessage();

		System.out.println("Actual error message on page: " + actualErrorMessage);
		System.out.println("Expected error message: " + expectedErrorMessage);

		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message mismatch!");
	}
}
