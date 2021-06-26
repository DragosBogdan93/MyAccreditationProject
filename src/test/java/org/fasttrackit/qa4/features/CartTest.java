package org.fasttrackit.qa4.features;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.qa4.steps.*;
import org.fasttrackit.qa4.utils.BaseTest;
import org.junit.After;
import org.junit.Test;

public class CartTest extends BaseTest {

    @Steps
    CartSteps cartSteps;
    @Steps
    MyAccountSteps myAccountSteps;
    @Steps
    SearchSteps searchSteps;
    @Steps
    ProductSteps productSteps;
    @Steps
    HomeSteps homeSteps;

    @Test
    public void addProductToCartWithLogin() {
        myAccountSteps.navigateToMyAccount();
        searchSteps.searchByKeyword("T-Shirt new green");
        productSteps.clickAddToCart();
        productSteps.checkAddedToCart();
    }

    @Test
    public void addProductToCartWithoutLogin() {
        homeSteps.navigateToHomepage();
        searchSteps.searchByKeyword("T-Shirt new green");
        productSteps.clickAddToCart();
        productSteps.checkAddedToCart();

    }

    @Test
    public void addMultipleProductsToCart() {
        myAccountSteps.navigateToMyAccount();
        searchSteps.searchByKeyword("T-Shirt");
        productSteps.addProductToCart("Blue T-Shirt");
        productSteps.addProductToCart("T-Shirt new green");
        productSteps.addProductToCart("New T-Shirt");
        homeSteps.clickViewCart();
        cartSteps.verifyCartContainProduct("Blue T-Shirt");
        cartSteps.verifyCartContainProduct("T-Shirt new green");
        cartSteps.verifyCartContainProduct("New T-Shirt");
    }

    @Test
    public void verifyProductPriceInCart() {
        homeSteps.navigateToHomepage();
        searchSteps.searchByKeyword("T-Shirt");
        productSteps.addProductToCart("Blue T-Shirt");
        productSteps.addProductToCart("T-Shirt new green");
        productSteps.addProductToCart("New T-Shirt");
        homeSteps.clickViewCart();
        cartSteps.verifyProductPricesIsCorrect();
    }

    @Test
    public void updateQuantityInCart() {
        cartSteps.addMultipleProductsToCart("T-shirt","New T-Shirt","T-Shirt with Logo","T-Shirt");
        cartSteps.setNewQuantities(4, 4, 5);
        cartSteps.clickUpdateCart();
        cartSteps.verifyUpdatedCart();
    }
    @Test
    public void verifyTotalProductsPriceIsCorrectAfterUpdateCart (){
        cartSteps.addMultipleProductsToCart("T-shirt","New T-Shirt","T-Shirt with Logo","T-Shirt");
        cartSteps.setNewQuantities(2, 5, 8);
        cartSteps.clickUpdateCart();
        cartSteps.verifyUpdatedCart();
        cartSteps.verifyProductPricesIsCorrect();
    }

    @After
    public void emptyCart() {
        cartSteps.navigateToCartPage();
        cartSteps.emptyCart();
        cartSteps.verifyCartIsEmpty();
    }
}
