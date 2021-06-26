package org.fasttrackit.qa4.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class MyAccountPage extends PageObject {

    @FindBy(id = "username")
    private WebElementFacade usernameField;
    @FindBy(id = "password")
    private WebElementFacade passwordField;
    @FindBy(id = "reg_email")
    private WebElementFacade regEmailField;
    @FindBy(id = "reg_password")
    private WebElementFacade regPasswordField;
    @FindBy(css = "button[name='login']")
    private WebElementFacade loginButton;
    @FindBy(css = "button[name='register']")
    private WebElementFacade registerButton;
    @FindBy(css = ".woocommerce-MyAccount-content p")
    private WebElementFacade successMessage;
    @FindBy(css = ".woocommerce-MyAccount-content p:nth-child(2)")
    private WebElementFacade successRegMessage;
    @FindBy(css = ".woocommerce-error li")
    private WebElementFacade errorMessage;
    @FindBy(css = ".woocommerce-LostPassword a")
    private WebElementFacade lostYourPasswordLink;
    @FindBy(css = ".woocommerce-MyAccount-navigation-link--customer-logout a")
    private WebElementFacade logoutLink;
    @FindBy(css = ".woocommerce-MyAccount-navigation-link--edit-address a")
    private WebElementFacade addressesLink;
    @FindBy(css = ".u-column1 .woocommerce-Address-title a")
    private WebElementFacade editBillingLink;
    @FindBy(css = ".u-column2 .woocommerce-Address-title a")
    private WebElementFacade editShippingLink;
    @FindBy(id = "billing_first_name")
    private WebElementFacade billingFirstNameField;
    @FindBy(id = "billing_last_name")
    private WebElementFacade billingLastNameField;
    @FindBy(id = "billing_address_1")
    private WebElementFacade billingStreetAddressField;
    @FindBy(id = "billing_city")
    private WebElementFacade billingCityNameField;
    @FindBy(id = "billing_postcode")
    private WebElementFacade billingPostcodeField;
    @FindBy(id = "billing_phone")
    private WebElementFacade billingPhoneNumberField;
    @FindBy(css = "button[name='save_address'")
    private WebElementFacade saveAddressButton;
    @FindBy(css = ".woocommerce-message")
    private WebElementFacade successEditBillingAddress;
    @FindBy(id = "shipping_first_name")
    private WebElementFacade shippingFirstNameField;
    @FindBy(id = "shipping_last_name")
    private WebElementFacade shippingLastNameField;
    @FindBy(id = "shipping_address_1")
    private WebElementFacade shippingStreetAddressField;
    @FindBy(id = "shipping_city")
    private WebElementFacade shippingCityNameField;
    @FindBy(id = "shipping_postcode")
    private WebElementFacade shippingPostcodeField;


    public void setUsernameField(String email) {
        typeInto(usernameField, email);
    }

    public void setPasswordField(String password) {
        typeInto(passwordField, password);
    }

    public void setEmailField(String email) {
        typeInto(regEmailField, email);
    }

    public void setRegPasswordField(String password) {
        typeInto(regPasswordField, password);
    }

    public void setBillingFirstNameField(String firstName) {
        typeInto(billingFirstNameField, firstName);
    }

    public void setBillingLastNameField(String lastName) {
        typeInto(billingLastNameField, lastName);
    }

    public void setBillingStreetAddressField(String streetAddress) {
        typeInto(billingStreetAddressField, streetAddress);
    }

    public void setBillingCityNameField(String cityName) {
        typeInto(billingCityNameField, cityName);
    }

    public void setBillingPostcodeField(Integer postcode) {
        typeInto(billingPostcodeField, String.valueOf(postcode));
    }

    public void setBillingPhoneNumberField(String number) {
        typeInto(billingPhoneNumberField, number);
    }

    public void setShippingFirstNameField(String firstName) {
        typeInto(shippingFirstNameField, firstName);
    }

    public void setShippingLastNameField(String lastName) {
        typeInto(shippingLastNameField, lastName);
    }

    public void setShippingStreetAddressField(String streetAddress) {
        typeInto(shippingStreetAddressField, streetAddress);
    }

    public void setShippingCityNameField(String cityName) {
        typeInto(shippingCityNameField, cityName);
    }

    public void setShippingPostcodeField(Integer postcode) {
        typeInto(shippingPostcodeField, String.valueOf(postcode));
    }

    public void clickLoginButton() {
        clickOn(loginButton);
    }

    public void clickRegisterButton() {
        clickOn(registerButton);
    }

    public void clickLostYourPasswordLink() {
        clickOn(lostYourPasswordLink);
    }

    public void clickLogoutLink() {
        clickOn(logoutLink);
    }

    public void clickAddressesLink() {
        clickOn(addressesLink);
    }

    public void clickEditBillingLink() {
        clickOn(editBillingLink);
    }

    public void clickEditShippingLink() {
        clickOn(editShippingLink);
    }

    public void clickSaveAddressLink() {
        clickOn(saveAddressButton);
    }

    public void verifyUserIsLogin(String message) {
        successMessage.shouldContainOnlyText(message);
    }

    public void checkInvalidUsernameFormatMessage() {
        errorMessage.shouldContainOnlyText("ERROR: Invalid username. Lost your password?");
    }

    public void checkInvalidPasswordMessage() {
        errorMessage.shouldContainOnlyText("ERROR: The password you entered for the email address test@gmail.com is incorrect. Lost your password?");
    }

    public void verifyNewAccountCreate() {
        successRegMessage.shouldContainOnlyText("From your account dashboard you can view your recent orders, manage your shipping and billing addresses and edit your password and account details.");
    }

    public void verifyAddressIsChanged() {
        successEditBillingAddress.shouldContainOnlyText("Address changed successfully.");
    }

    public void isNewAccountCreated() {
        registerButton.shouldBePresent();
    }

    public void isUserLogout() {
        loginButton.shouldBePresent();
    }
}