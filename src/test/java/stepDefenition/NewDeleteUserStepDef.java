package stepDefenition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utilities.ExcelUtils;

import java.io.IOException;
import java.util.Map;

public class NewDeleteUserStepDef extends BaseStepDef {
	String actualUsername;
	String actualEmailAddress;

	@Given("Click on Signup Login button")
	public void clickOnSignupLoginButton() {
		homeFlow.clickOnSignupButton();
	}

	@When("Verify New User Signup is visible")
	public void verifyNewUserSignupIsVisible() {
		signupLoginFlow.verifyLoginSignupPageVisible();
	}

	@And("Enter name {string}, email address {string}")
	public void enterNameEmailAddress(String name, String emailAddress) {
		actualUsername = name;
		actualEmailAddress = emailAddress;
		signupLoginFlow.enterTheNameEmailInSignupTextBox(actualUsername, actualEmailAddress);
	}

	@Then("Verify error {string} in signup is visible")
	public void verifyErrorEmailAddressAlreadyExistInSignupIsVisible(String expectedErrorMessage) {
		String actualErrorMessage = signupLoginFlow.getErrorMessageSignup();
		System.out.println("Actual error message on page: " + actualErrorMessage);
		System.out.println("Expected error message: " + expectedErrorMessage);
		Assert.assertEquals(expectedErrorMessage, "Email Address already exist!", actualErrorMessage);
	}

	@And("Verify ENTER ACCOUNT INFORMATION is visible")
	public void verifyENTERACCOUNTINFORMATIONIsVisible() {
		registrationFlow.verifyTheTextPresent();
	}

	@And("Verify ACCOUNT CREATED is visible and click Continue button")
	public void verifyACCOUNTCREATEDIsVisibleAndClickContinueButton() {
		registrationFlow.verifyTheTextAccountCreated();
	}

	@And("Verify Login in as {string} is visible")
	public void verifyLoginInAsUsernameIsVisible(String expectedUsername) {
		loginFlow.verifyLoginUserName(expectedUsername);
	}

	@And("click Signup button")
	public void clickSignupButton() {
		signupLoginFlow.clickSignupButton();
	}

	@And("Click Delete Account button")
	public void clickDeleteAccountButton() {
		loginFlow.clickDeleteAccountButton();
	}

	@Then("Verify that Account Deleted is visible and click continue")
	public void verify_that_account_deleted_is_visible_and_click_continue() {
		loginFlow.verifyAccountDeleteTextVisible();
	}

	@And("Enter name {string} and already registered email address {string}")
	public void enterNameAndAlreadyRegisteredEmailAddress(String name, String emailAddress) {
		signupLoginFlow.enterTheNameEmailInSignupTextBox(name, emailAddress);
	}

	@Given("Add products to cart")
	public void addProductsToCart() {
		productFlow.productToCart();
	}

	@When("Click cart button")
	public void clickCartButton() {
		productFlow.clickCart();
	}

	@And("Verify that cart page is displayed")
	public void verifyThatCartPageIsDisplayed() {
		cartFlow.verifyTheCartPage();
	}

	@And("Click Proceed To Checkout")
	public void clickProceedToCheckout() {
		cartFlow.clickCheckoutButton();
	}

	@And("Click RegisterLogin button")
	public void clickRegisterLoginButton() {
		cartFlow.registerLogin();
	}

	@And("Fill all details in Signup and create account")
	public void fillAllDetailsInSignupAndCreateAccount() {
		actualUsername = "hello";
		actualEmailAddress = "r1h3l34@gmail.com";
		signupLoginFlow.enterTheNameEmailInSignupTextBox(actualUsername, actualEmailAddress);
		signupLoginFlow.clickSignupButton();
		registrationFlow.verifyTheTextPresent();
	}

	@And("Click Cart button from login page")
	public void clickCartButtonFromLoginPage() {
		cartFlow.clickCartButton();
	}

	@And("Verify Address Details and Review Your Order")
	public void verifyAddressDetailsAndReviewYourOrder() {
		cartFlow.verifyAddressDetails();
	}

	@And("Enter description in {string} text area and click Place Order")
	public void enterDescriptionInCommentTextAreaAndClickPlaceOrder(String comment) {
		cartFlow.enterDescriptionInCart(comment);
	}


	@And("Click Pay and Confirm Order button")
	public void clickPayAndConfirmOrderButton() {
		cartFlow.clickPayAndConfirm();
	}

	@And("Verify success message {string}")
	public void verifySuccessMessageYourOrderHasBeenPlacedSuccessfully(String expectedMessage) {
		cartFlow.verifySuccessMessageYourOrder(expectedMessage);
	}

	@And("Enter the details in the Signup form from given sheetname {string} and rownumber {int}")
	public void enterTheDetailsInTheSignupFormAndClickCreateAccountButton(String sheetName, int rowNumber) throws IOException {
		Map<String, String> data = ExcelUtils.getRowData(sheetName, rowNumber);

		registrationFlow.fillRegistrationForm(
				data.get("password"), data.get("first"), data.get("last"), data.get("company"),
				data.get("address1"), data.get("address2"), data.get("country"), data.get("state"),
				data.get("city"), data.get("zip"), data.get("mobile"), data.get("date"), data.get("month"), data.get("year")
		);
	}


	@And("Enter payment details from given Excel Sheet {string} and rowNumber {int}")
	public void enterPaymentDetailsFromGivenExcelSheetAndRowNumber(String cardSheet, int RowNum) throws IOException {
		Map<String, String> data = ExcelUtils.getRowData(cardSheet, RowNum);

		String nameOnCard = data.get("Name on Card");
		String cardNumber = data.get("Card Number");
		String cvc = data.get("CVC");
		String expMonth = data.get("Expiry Month");
		String expYear = data.get("Expiry Year");

		cartFlow.enterPaymentDetails(nameOnCard, cardNumber, cvc, expMonth, expYear);
	}
}
