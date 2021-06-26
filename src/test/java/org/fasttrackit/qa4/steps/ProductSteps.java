package org.fasttrackit.qa4.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.qa4.pages.HomePage;
import org.fasttrackit.qa4.pages.ProductPage;
import org.junit.Assert;

public class ProductSteps {

    private ProductPage productPage;
    private HomePage homePage;

    @Step
    public void clickProduct() {
        productPage.clickProductLink();
    }

    @Step
    public void clickReview() {
        productPage.clickReviewButton();
    }

    @Step
    public void selectStarsReview(int starsNumber) {
        productPage.selectStarsReview(starsNumber);
    }

    @Step
    public void enterReviewText(String reviewText) {
        productPage.setReviewField(reviewText);
    }

    @Step
    public void clickSubmit() {
        productPage.clickSubmitButton();
    }

    @Step
    public void verifySuccessReview(String comment) {
        productPage.verifySuccessReview(comment);
    }

    @Step
    public void enterName(String name) {
        productPage.setNameField(name);
    }

    @Step
    public void enterEmail(String email) {
        productPage.setEmailField(email);
    }

    @Step
    public void isErrorMessageDisplay(String text) {
        Assert.assertTrue(productPage.isErrorMessageDisplay(text));
    }

    @Step
    public void enterCredentialsReview(int starsNumber, String reviewText, String name, String email) {
        productPage.selectStarsReview(starsNumber);
        productPage.setReviewField(reviewText);
        productPage.setNameField(name);
        productPage.setEmailField(email);
    }

    @Step
    public void clickAddToCart() {
        productPage.clickAddToCartButton();
    }

    @Step
    public void checkAddedToCart() {
        Assert.assertTrue(productPage.isAddedToCart());
    }

    @Step
    public void addProductToCart(String productName) {
        Assert.assertTrue("The product was not found!", productPage.addProductToCart(productName));
    }

    @Step
    public void enterQuantity(Integer quantityValue) {
        productPage.setQuantityField(quantityValue);
    }

    @Step
    public void verifyAddedToCart(Integer quantityValue, String message) {
        productPage.verifyAddedToCart(quantityValue, message);
    }
}

