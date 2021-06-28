package org.fasttrackit.qa4.steps;
import net.thucydides.core.annotations.Step;
import org.fasttrackit.qa4.pages.HomePage;
import org.fasttrackit.qa4.pages.MyAccountPage;
import org.fasttrackit.qa4.utils.Constants;

public class MyAccountSteps {

    private MyAccountPage myAccountPage;
    private HomePage homePage;

    @Step
    public void enterCredentials(String username, String password) {
        myAccountPage.setUsernameField(username);
        myAccountPage.setPasswordField(password);
    }

    @Step
    public void clickLogin() {
        myAccountPage.clickLoginButton();
    }

    @Step
    public void clickRegister() {
        myAccountPage.clickRegisterButton();
    }

    @Step
    public void checkUserIsLoggedIn(String message) {
        myAccountPage.verifyUserIsLogin(message);
    }

    @Step
    public void verifyInvalidUsernameFormatMessage() {
        myAccountPage.checkInvalidUsernameFormatMessage();
    }

    @Step
    public void verifyInvalidPasswordMessage() {
        myAccountPage.checkInvalidPasswordMessage();
    }

    @Step
    public void enterRegCredentials(String email, String password) {
        myAccountPage.setEmailField(email);
        myAccountPage.setRegPasswordField(password);
    }

    @Step
    public void verifyNewAccountCreate() {
        myAccountPage.verifyNewAccountCreate();
    }

    @Step
    public void isNewAccountCreated() {
        myAccountPage.isNewAccountCreated();
    }

    @Step
    public void clickLostYourPassword() {
        myAccountPage.clickLostYourPasswordLink();
    }

    @Step
    public void clickLogout() {
        myAccountPage.clickLogoutLink();
    }

    @Step
    public void clickAddresses() {
        myAccountPage.clickAddressesLink();
    }

    @Step
    public void clickEditBillingAddress() {
        myAccountPage.clickEditBillingLink();
    }

    @Step
    public void clickEditShippingAddress() {
        myAccountPage.clickEditShippingLink();
    }


    @Step
    public void isUserLogout() {
        myAccountPage.isUserLogout();
    }

    @Step
    public void navigateToMyAccount() {
        homePage.open();
        homePage.clickAccountLink();
        myAccountPage.setUsernameField(Constants.USER_EMAIL);
        myAccountPage.setPasswordField(Constants.USER_PASSWORD);
        myAccountPage.clickLoginButton();
    }

    @Step
    public void enterBillingAddressCredentials(String firstName, String lastName, String streetAddress, String cityName, int postcode, String phoneNumber) {
        myAccountPage.setBillingFirstNameField(firstName);
        myAccountPage.setBillingLastNameField(lastName);
        myAccountPage.setBillingStreetAddressField(streetAddress);
        myAccountPage.setBillingCityNameField(cityName);
        myAccountPage.setBillingPostcodeField(postcode);
        myAccountPage.setBillingPhoneNumberField(phoneNumber);
    }

    @Step
    public void clickSaveAddress() {
        myAccountPage.clickSaveAddressLink();
    }

    @Step
    public void verifyAddressIsChanged() {
        myAccountPage.verifyAddressIsChanged();
    }

    @Step
    public void enterShippingAddressCredentials(String firstName, String lastName, String streetAddress, String cityName, int postcode) {
        myAccountPage.setShippingFirstNameField(firstName);
        myAccountPage.setShippingLastNameField(lastName);
        myAccountPage.setShippingStreetAddressField(streetAddress);
        myAccountPage.setShippingCityNameField(cityName);
        myAccountPage.setShippingPostcodeField(postcode);
    }
}
