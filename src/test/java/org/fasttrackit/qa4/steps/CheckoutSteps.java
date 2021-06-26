package org.fasttrackit.qa4.steps;
import net.thucydides.core.annotations.Step;
import org.fasttrackit.qa4.pages.CheckoutPage;
import org.junit.Assert;

public class CheckoutSteps {

    private CheckoutPage checkoutPage;

    @Step
    public void verifyInfoMessageIsDisplayed(String text) {
        checkoutPage.verifyInfoMessageIsDisplayed(text);
    }

    @Step
    public void clickEnterYourCode() {
        checkoutPage.clickCouponCodeDropdownField();
    }

    @Step
    public void enterCouponCode(String text) {
        checkoutPage.setCouponCodeField(text);
    }

    @Step
    public void clickApplyCoupon(){
        checkoutPage.clickApplyCouponButton();
    }

    @Step
    public void verifyAppliedSuccessfully() {
        checkoutPage.verifySuccessMessage();
    }

    @Step
    public void verifyErrorMessageIsDisplayed(String text){
        checkoutPage.verifyErrorMessage(text);
    }

    @Step
    public void verifyCouponIsApply(String name) {
        Assert.assertTrue("The discount price doesn't apply!",checkoutPage.isCouponApply(name));
    }

    @Step
    public void enterCredentials(String firstName,String lastName,String countryName,String streetAddressName,String cityName,String stateName,Integer postcodeNumber,Long phoneNumber,String email) {
        checkoutPage.setFirstNameField(firstName);
        checkoutPage.setLastNameField(lastName);
        checkoutPage.setCountryDropdown(countryName);
        checkoutPage.setStreetAddressField(streetAddressName);
        checkoutPage.setCityField(cityName);
        checkoutPage.setStateField(stateName);
        checkoutPage.setPostcodeField(postcodeNumber);
        checkoutPage.setPhoneField(phoneNumber);
        checkoutPage.setEmailField(email);
    }

    @Step
    public void clickPlaceOrder(){
        checkoutPage.clickPlaceOrderButton();
    }

    @Step
    public void isTheOrderPlaced(String text) {
        Assert.assertTrue(checkoutPage.verifyOrderWasPlaced(text));
    }
}