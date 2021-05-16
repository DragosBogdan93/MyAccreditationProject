package org.fasttrackit.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.pages.CartPage;
import org.fasttrackit.pages.HomePage;

public class CartSteps {
    private CartPage cartPage;
    private HomePage homePage;
    @Step
    public void navigateToHomePage() {
    homePage.open();
    }


    @Step
    public void navigateToSale() {
        cartPage.clickSaleLink();
    }
    @Step
    public void clickProduct() {
        cartPage.clickProductLink();
    }
    @Step
    public void selectColor() {
        cartPage.clickColorButton();
    }
    @Step
    public void selectSize() {
        cartPage.clickSizeButton();
    }
    @Step
    public void addToCart () {
        cartPage.clickAddToCartButton();
    }
    @Step
    public void checkProductIsInCart(String message) {
        cartPage.checkProductIsInTheCart(message);
    }

}
