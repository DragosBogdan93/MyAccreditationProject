package org.fasttrackit.qa4.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.actions.Clear;
import java.util.List;

public class ProductPage extends PageObject {

    @FindBy(css = ".products :first-of-type li:nth-child(2) .woocommerce-LoopProduct-link")
    private WebElementFacade secondProductLink;
    @FindBy(css = ".products :first-of-type li:first-child .woocommerce-LoopProduct-link")
    private WebElementFacade productLink;
    @FindBy(id = "tab-title-reviews")
    private WebElementFacade reviewButton;
    @FindBy(css = ".stars span a")
    private List<WebElementFacade> selectStarsIcon;
    @FindBy(id = "comment")
    private WebElementFacade reviewField;
    @FindBy(id = "submit")
    private WebElementFacade submitButton;
    @FindBy(css = ".commentlist li:last-child .description")
    private WebElementFacade yourCommentText;
    @FindBy(id = "author")
    private WebElementFacade nameField;
    @FindBy(id = "email")
    private WebElementFacade emailField;
    @FindBy(css = "#error-page > p:nth-child(2)")
    private WebElementFacade errorMessage;
    @FindBy(css = ".single_add_to_cart_button")
    private WebElementFacade addToCartButton;
    @FindBy(css = ".woocommerce-message")
    private WebElementFacade confirmAddToCartMessage;
    @FindBy(css = "li.product")
    private List<WebElementFacade> listOfProducts;
    @FindBy(css = ".input-text")
    private WebElementFacade quantityField;


    public void clickProductLink() {
        clickOn(productLink);
    }
    public void clickProduct(){
        clickOn(secondProductLink);
    }

    public void clickReviewButton() {
        clickOn(reviewButton);
    }

    public void selectStarsReview(int starsReview) {
        selectStarsIcon.get(starsReview - 1).click();
    }

    public void setReviewField(String comment) {
        typeInto(reviewField, comment);
    }

    public void clickSubmitButton() {
        clickOn(submitButton);
    }

    public void verifySuccessReview(String comment) {
        yourCommentText.shouldContainOnlyText(comment);
    }

    public void setNameField(String name) {
        nameField.clear();
        typeInto(nameField, name);
    }

    public void setEmailField(String email) {
        emailField.clear();
        typeInto(emailField, email);
    }

    public boolean isErrorMessageDisplay(String text) {
        return errorMessage.containsText(text);
    }

    public void clickAddToCartButton() {
        clickOn(addToCartButton);
    }

    public boolean isAddedToCart() {
        return confirmAddToCartMessage.containsText("“T-Shirt new green” has been added to your cart.");
    }

    public boolean addProductToCart(String name) {
        for (WebElementFacade elementFacade : listOfProducts) {
            if (elementFacade.findElement(By.cssSelector(".products h2")).getText().equalsIgnoreCase(name)) {
                elementFacade.findElement(By.cssSelector(".products .button")).click();
                return true;
            }
        }
        return false;
    }

    public void setQuantityField(int quantity) {
        quantityField.clear();
        typeInto(quantityField, String.valueOf(quantity));
    }

    public void verifyAddedToCart(Integer quantityValue, String message) {
        confirmAddToCartMessage.shouldContainText(quantityValue + message);
    }
}
