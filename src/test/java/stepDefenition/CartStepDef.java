package stepDefenition;

import flows.CartFlow;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartStepDef extends BaseStepDef {
	String emailAddress;

	@Given("Click Cart button")
	public void clickCartButton() {
		cartFlow = new CartFlow(driver);
		cartFlow.clickCartButton();
	}

	@When("Scroll down to footer")
	public void scrollDownToFooter() {
		cartFlow.scrollDownToFooter();
	}

	@And("Verify text {string}")
	public void verifyTextSUBSCRIPTION(String subscription) {
		cartFlow.verifyTheTextSubscription(subscription);
	}

	@And("Enter email {string} in input and click arrow button")
	public void enterEmailAddressInInputAndClickArrowButton(String email) {
		emailAddress = email;
		cartFlow.enterEmailAddressInInput(emailAddress);
	}

	@Then("Verify success message {string} is visible")
	public void verifySuccessMessageYouHaveBeenSuccessfullySubscribedIsVisible(String expectedMessage) {
		cartFlow.verifySuccessMessage(expectedMessage);
	}

	@Given("Click view Product for any product on home page")
	public void clickViewProductForAnyProductOnHomePage() {
		cartFlow.clickViewProductForAnyProductOnHomePage();
	}

	@Given("Click products button")
	public void clickProductsButton() {
		productFlow.openProductPage();
	}

	@When("Hover over first product and click add to cart")
	public void hoverOverFirstProductAndClickAddToCart() {
		cartFlow.hoverOverFirstProductAddToCart();
	}

	@And("Click Continue Shopping button")
	public void clickContinueShoppingButton() {
		cartFlow.continueShopping();
	}

	@And("Hover over second product and click add to cart")
	public void hoverOverSecondProductAndClickAddToCart() {
		cartFlow.hoverOverSecoundProductAddToCart();
	}

	@And("Click view Cart link")
	public void clickViewCartLink() {
		cartFlow.viewCart();
	}

	@And("Verify both products are added to Cart")
	public void verifyBothProductsAreAddedToCart() {
		cartFlow.verifyProduct();
	}

	@Then("Verify their prices, quantity and total price")
	public void verifyTheirPricesQuantityAndTotalPrice() {
		cartFlow.verifyCartProductDetails("product-1", 500, 1);
		cartFlow.verifyCartProductDetails("product-2", 400, 1);
	}

	@When("Verify product detail is opened")
	public void verifyProductDetailIsOpened() {
		cartFlow.verifyProductDetail();
	}

	@And("Click on add to cart button")
	public void clickOnAddToCartButton() {
		cartFlow.clickAddToCartButton();
	}

	@Then("Verify that product is displayed in cart page with exact quantity")
	public void verifyThatProductIsDisplayedInCartPageWithExactQuantity() {
		cartFlow.verifyThatProductIsDisplayedInCart();
	}

	@And("Verify cart page is displayed")
	public void verifyCartPageIsDisplayed() {
		cartFlow.verifyTheCartPage();
	}

	@And("Click X button corresponding to particular product")
	public void clickXButtonCorrespondingToParticularProduct() {
		cartFlow.clickXButtonToParticularProduct();
	}

	@Then("Verify that product is removed from the cart")
	public void verifyThatProductIsRemovedFromTheCart() {
		cartFlow.verifyThatProductIsRemovedFromCart();
	}

	@And("Increase quantity to {string}")
	public void increaseQuantityTo(String quantity) {
		int qty = Integer.parseInt(quantity);
		cartFlow.increaseQuantity(String.valueOf(qty));
	}

}
