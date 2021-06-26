package org.fasttrackit.qa4.features;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.qa4.steps.HomeSteps;
import org.fasttrackit.qa4.steps.MyAccountSteps;
import org.fasttrackit.qa4.utils.BaseTest;
import org.fasttrackit.qa4.utils.Constants;
import org.junit.Test;

public class MyAccountTest extends BaseTest {

    @Steps
    private MyAccountSteps myAccountSteps;
    @Steps
    private HomeSteps homeSteps;

    @Test
    public void loginWithValidCredentials() {
        homeSteps.navigateToLogin();
        myAccountSteps.enterCredentials(Constants.USER_EMAIL, Constants.USER_PASSWORD);
        myAccountSteps.clickLogin();
        myAccountSteps.checkUserIsLoggedIn("Hello test1 (not test1? Log out)");
    }

    @Test
    public void loginWithInvalidUsernameFormat() {
        homeSteps.navigateToLogin();
        myAccountSteps.enterCredentials(Constants.INVALID_USERNAME, Constants.USER_PASSWORD);
        myAccountSteps.clickLogin();
        myAccountSteps.verifyInvalidUsernameFormatMessage();
    }

    @Test
    public void loginWithInvalidPassword() {
        homeSteps.navigateToLogin();
        myAccountSteps.enterCredentials(Constants.USER_EMAIL, Constants.USER_INVALID_PASSWORD);
        myAccountSteps.clickLogin();
        myAccountSteps.verifyInvalidPasswordMessage();
    }

    @Test
    public void registerNewUserAccount() {
        homeSteps.navigateToRegister();
        myAccountSteps.enterRegCredentials(Constants.RANDOM_USER_EMAIL, Constants.RANDOM_USER_PASSWORD);
        myAccountSteps.clickRegister();
        myAccountSteps.verifyNewAccountCreate();
    }

    @Test
    public void registerWithInvalidCredentials() {
        homeSteps.navigateToRegister();
        myAccountSteps.enterRegCredentials(Constants.INVALID_EMAIL_FORMAT, Constants.RANDOM_USER_PASSWORD);
        myAccountSteps.clickRegister();
        myAccountSteps.isNewAccountCreated();
    }

    @Test
    public void logoutUserAccount() {
        myAccountSteps.navigateToMyAccount();
        myAccountSteps.clickLogout();
        myAccountSteps.isUserLogout();
    }

    @Test
    public void editBillingAddress() {
        myAccountSteps.navigateToMyAccount();
        myAccountSteps.clickAddresses();
        myAccountSteps.clickEditBillingAddress();
        myAccountSteps.enterBillingAddressCredentials(Constants.USER_FIRSTNAME, Constants.USER_LASTNAME, Constants.USER_STREET_ADDRESS, Constants.USER_CITY_NAME, Constants.USER_POSTCODE, Constants.USER_PHONE_NUMBER);
        myAccountSteps.clickSaveAddress();
        myAccountSteps.verifyAddressIsChanged();
    }

    @Test
    public void editShippingAddress() {
        myAccountSteps.navigateToMyAccount();
        myAccountSteps.clickAddresses();
        myAccountSteps.clickEditShippingAddress();
        myAccountSteps.enterShippingAddressCredentials(Constants.USER_FIRSTNAME, Constants.USER_LASTNAME, Constants.USER_STREET_ADDRESS, Constants.USER_CITY_NAME, Constants.USER_POSTCODE);
        myAccountSteps.clickSaveAddress();
        myAccountSteps.verifyAddressIsChanged();
    }
}
