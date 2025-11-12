package stepDefenition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;
import java.util.Map;

public class ProductPageStepDef extends BaseStepDef {

	@Given("Click on products button")
	public void clickOnProductsButton() {
		productFlow.openProductPage();
	}

	@When("Verify user is navigated to All Products page successfully")
	public void verifyUserIsNavigatedToAllProductsPageSuccessfully() {
		productFlow.verifyProductPageTitle();
	}

	@And("The products list is visible")
	public void theProductsListIsVisible() {
		Assert.assertTrue(productFlow.verifyAllProducts(), "All Products heading is not visible!");
	}

	@And("Click on View Product of first product")
	public void clickOnViewProductOfFirstProduct() {
		productFlow.clickFirstViewProduct();
	}

	@And("User is landed to product detail page")
	public void userIsLandedToProductDetailPage() {
		productFlow.verifyProductDetailPageTitle();
	}

	@And("Enter product {string} in search input and click search button")
	public void enterProductNameInSearchInputAndClickSearchButton(String productName) {
		productFlow.enterProductName(productName);
	}

	@And("Verify {string} is visible")
	public void verifySearchedProductIsVisible(String productCategory) {
		boolean isVisible = productFlow.verifyEnterProductIsVisible(productCategory);
		if (isVisible) {
			System.out.println("Product '" + productCategory + "' is visible");
		}
		else {
			System.out.println("Product '" + productCategory + "' is not visible");
		}
	}

	@Then("Verify that detail detail is visible")
	public void verifyThatDetailDetailIsVisibleProductNameCategoryPriceAvailabilityConditionBrand() {
		productFlow.areProductDetailsVisible();
		Assert.assertTrue(productFlow.areProductDetailsVisible(),"Not all product details are visible!");
	}

	@When("Verify that categories are visible on left side bar")
	public void verifyThatCategoriesAreVisibleOnLeftSideBar() {
		productFlow.verifyThatCategoriesAreVisible();
	}

	@And("Click on {string} category")
	public void clickOnWomenCategory(String categoryName) {
		productFlow.clickOnWomenCategory(categoryName);
	}

	@And("Click on {string} category link under Women category")
	public void clickOnAnyCategoryLinkUnderWomenCategory(String subCategoryName) {
		productFlow.clickOnWomenProduct(subCategoryName);
	}

	@And("Verify that category page is displayed and confirm text {string}")
	public void verifyThatCategoryPageIsDisplayedAndConfirmTextWOMENTOPSPRODUCTS(String expectedCategoryName) {
		boolean isDisplayed = productFlow.isCategoryPageDisplayed(expectedCategoryName);
		Assert.assertTrue(isDisplayed);
	}

	@And("On left side bar, click on {string} sub-category link of {string} category")
	public void onLeftSideBarClickOnAnySubCategoryLinkOfMenCategory(String subCategoryName, String categoryName) {
		productFlow.onLeftSideBarClickOnAnySubCategory(subCategoryName, categoryName );
	}

	@And("Verify that user is navigated to {string} category page")
	public void verifyThatUserIsNavigatedToThatCategoryPage(String expectedCategoryName) {
		boolean isDisplayed = productFlow.isCategoryPageDisplayed(expectedCategoryName);
		Assert.assertTrue(isDisplayed);
	}

}
