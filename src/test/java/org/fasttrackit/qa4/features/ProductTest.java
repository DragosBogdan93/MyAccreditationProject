package org.fasttrackit.qa4.features;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.qa4.steps.HomeSteps;
import org.fasttrackit.qa4.steps.MyAccountSteps;
import org.fasttrackit.qa4.steps.ProductSteps;
import org.fasttrackit.qa4.utils.BaseTest;
import org.fasttrackit.qa4.utils.Constants;
import org.junit.Test;

public class ProductTest extends BaseTest {

    @Steps
    private HomeSteps homeSteps;
    @Steps
    private MyAccountSteps myAccountSteps;
    @Steps
    private ProductSteps productSteps;

    @Test
    public void addReviewWithLogin() {
        String reviewText = Constants.RANDOM_REVIEW;
        myAccountSteps.navigateToMyAccount();
        homeSteps.navigateToShop();
        productSteps.clickProduct();
        productSteps.clickReview();
        productSteps.selectStarsReview(4);
        productSteps.enterReviewText(reviewText);
        productSteps.clickSubmit();
        productSteps.verifySuccessReview(reviewText);
    }

    @Test
    public void addReviewWithoutLogin() {
        homeSteps.navigateToHomepage();
        homeSteps.navigateToShop();
        productSteps.clickProduct();
        productSteps.clickReview();
        productSteps.selectStarsReview(1);
        productSteps.enterReviewText("I hate this product!");
        productSteps.enterName("Bogdan");
        productSteps.enterEmail(Constants.RANDOM_USER_EMAIL);
        productSteps.clickSubmit();
        productSteps.verifySuccessReview("I hate this product!");
    }

    @Test
    public void addReviewWithInvalidCredentials() {
        homeSteps.navigateToHomepage();
        homeSteps.navigateToShop();
        productSteps.clickProduct();
        productSteps.clickReview();
        productSteps.enterCredentialsReview(4, "I wanna test something", Constants.USER_FIRSTNAME, Constants.INVALID_EMAIL_FORMAT);
        productSteps.clickSubmit();
        productSteps.isErrorMessageDisplay("ERROR: please enter a valid email address.");
    }

    @Test
    public void addDifferentQuantitiesInCart() {
        homeSteps.navigateToHomepage();
        homeSteps.navigateToShop();
        productSteps.clickProduct();
        productSteps.enterQuantity(5);
        productSteps.clickAddToCart();
        productSteps.verifyAddedToCart(5, " × “Album” have been added to your cart.");
    }
}

