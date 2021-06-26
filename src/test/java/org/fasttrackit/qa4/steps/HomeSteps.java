package org.fasttrackit.qa4.steps;
import net.thucydides.core.annotations.Step;
import org.fasttrackit.qa4.pages.HomePage;
import org.junit.Assert;

public class HomeSteps {

    private HomePage homePage;

    @Step
    public void navigateToLogin() {
        homePage.open();
        homePage.clickAccountLink();
    }

    @Step
    public void navigateToRegister() {
        homePage.open();
        homePage.clickAccountLink();
    }

    @Step
    public void navigateToHomepage() {
        homePage.open();
    }

    @Step
    public void navigateToShop() {
        homePage.open();
        homePage.clickShopLink();
    }

    @Step
    public void clickViewCart() {
        homePage.clickViewCartLink();
    }

    @Step
    public void clickCheckout(){
        homePage.clickCheckoutLink();
    }

    @Step
    public void pauseFor(Integer milliseconds){
        homePage.pauseFor(milliseconds);
    }

    @Step
    public void searchByKeyword(String text) {
        homePage.setBottomSearchField(text);
    }

    @Step
    public void clickSearch() {
        homePage.clickBottomSearchIcon();
    }

    @Step
    public void checkResultsContains(String productName) {
        Assert.assertTrue("The product was not found!", homePage.isProductInList(productName));
    }

    @Step
    public void verifyMessageIsDisplay(String text){
        Assert.assertTrue("The search result was found !",homePage.verifyMessageIsDisplay(text));
    }
}


