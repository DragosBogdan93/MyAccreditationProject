package org.fasttrackit.qa4.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class CheckoutPage extends PageObject {

    @FindBy(css = ".cart-empty")
    private WebElementFacade infoMessage;
    @FindBy(css = ".showcoupon")
    private WebElementFacade couponCodeDropdownField;
    @FindBy(id = "coupon_code")
    private WebElementFacade couponCodeField;
    @FindBy(css = ".form-row.form-row-last .button")
    private WebElementFacade applyCouponButton;
    @FindBy(css = ".woocommerce-message")
    private WebElementFacade successAppliedMessage;
    @FindBy(css = ".woocommerce-error")
    private WebElementFacade errorMessage;
    @FindBy(css = ".shop_table > tfoot tr")
    private List<WebElementFacade> priceList;
    @FindBy(id = "billing_first_name")
    private WebElementFacade firstNameField;
    @FindBy(id = "billing_last_name")
    private WebElementFacade lastNameField;
    @FindBy(id = "billing_country")
    private WebElementFacade countryDropdown;
    @FindBy(css = ".input-text#billing_address_1")
    private WebElementFacade streetAddressField;
    @FindBy(css = ".input-text#billing_city")
    private WebElementFacade cityField;
    @FindBy(css = ".input-text#billing_state")
    private WebElementFacade stateField;
    @FindBy(css = ".input-text#billing_postcode")
    private WebElementFacade postcodeField;
    @FindBy(css = ".input-text#billing_phone")
    private WebElementFacade phoneField;
    @FindBy(css = ".input-text#billing_email")
    private WebElementFacade emailField;
    @FindBy(id = "place_order")
    private WebElementFacade placeOrderButton;
    @FindBy(css = ".woocommerce-thankyou-order-received")
    private WebElementFacade successPlaceOrderMessage;

    public void verifyInfoMessageIsDisplayed(String text) {
        infoMessage.shouldContainOnlyText(text);
    }

    public void clickCouponCodeDropdownField() {
        clickOn(couponCodeDropdownField);
    }

    public void setCouponCodeField(String text) {
        typeInto(couponCodeField, text);
    }

    public void clickApplyCouponButton() {
        clickOn(applyCouponButton);
    }

    public void verifySuccessMessage() {
        successAppliedMessage.shouldContainOnlyText("Coupon code applied successfully.");
    }

    public void verifyErrorMessage(String text) {
        errorMessage.shouldContainOnlyText("Coupon \"" + text + "\" does not exist!");
    }

    public boolean isCouponApply(String productName) {
        for (WebElementFacade element : priceList) {
            if (element.findElement(By.xpath("//*[@id=\"order_review\"]/table/tfoot/tr[2]/th")).getText().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public void setFirstNameField(String firstName) {
        typeInto(firstNameField, firstName);
    }

    public void setLastNameField(String lastName) {
        typeInto(lastNameField, lastName);
    }

    public void setCountryDropdown(String name) {
        selectFromDropdown(countryDropdown, name);
    }

    public void setStreetAddressField(String name) {
        typeInto(streetAddressField, name);
    }

    public void setCityField(String name) {
        typeInto(cityField, name);
    }

    public void setStateField(String name) {
        typeInto(stateField, name);
    }

    public void setPostcodeField(Integer number) {
        typeInto(postcodeField, String.valueOf(number));
    }

    public void setPhoneField(Long number) {
        typeInto(phoneField, String.valueOf(number));
    }

    public void setEmailField(String email) {
        typeInto(emailField, email);
    }

    public void clickPlaceOrderButton() {
        clickOn(placeOrderButton);
    }

    public boolean verifyOrderWasPlaced(String text) {
        return successPlaceOrderMessage.containsOnlyText(text);
    }

}


