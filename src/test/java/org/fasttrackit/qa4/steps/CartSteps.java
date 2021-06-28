package org.fasttrackit.qa4.steps;
import net.thucydides.core.annotations.Step;
import org.fasttrackit.qa4.pages.CartPage;
import org.fasttrackit.qa4.pages.HomePage;
import org.fasttrackit.qa4.pages.ProductPage;
import org.junit.Assert;

public class CartSteps {

    private CartPage cartPage;
    private HomePage homePage;
    private ProductPage productPage;

    @Step
    public void verifyCartContainProduct(String name) {
        Assert.assertTrue(cartPage.isProductInCart(name));
    }

    @Step
    public void navigateToCartPage() {
        homePage.openUrl("http://qa4.fasttrackit.org:8008/?page_id=118");
    }

    @Step
    public void emptyCart() {
        cartPage.removeProductsFromCart();
    }

    @Step
    public void verifyCartIsEmpty() {
        cartPage.successEmptyCartMessage();
    }

    @Step
    public void verifyProductPricesIsCorrect() {
        Assert.assertTrue(cartPage.isCarTotalCalculatedCorrectly());
    }

    @Step
    public void setNewQuantities(int firstQuantity, int secondQuantity, int thirdQuantity) {
        cartPage.setFirstQuantityField(firstQuantity);
        cartPage.setSecondQuantityField(secondQuantity);
        cartPage.setThirdQuantityField(thirdQuantity);
    }

    @Step
    public void clickUpdateCart() {
        cartPage.clickUpdateCartButton();
    }

    @Step
    public void verifyUpdatedCart() {
        cartPage.verifySuccessUpdateCartMessage();
    }

    @Step
    public void addMultipleProductsToCart(String productSearchName, String firstProductName, String secondProductName, String thirdProductName) {
        homePage.open();
        homePage.clickSearchIcon();
        homePage.setSearchField(productSearchName);
        homePage.clickSecondSearchIcon();
        Assert.assertTrue("The product was not found!", productPage.addProductToCart(firstProductName));
        homePage.pauseFor(300);
        Assert.assertTrue("The product was not found!", productPage.addProductToCart(secondProductName));
        homePage.pauseFor(300);
        Assert.assertTrue("The product was not found!", productPage.addProductToCart(thirdProductName));
        homePage.pauseFor(300);
        homePage.clickViewCartLink();
    }
}
