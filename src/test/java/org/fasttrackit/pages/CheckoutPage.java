package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends PageObject {
@FindBy(css = ".bottom button")
    private WebElementFacade proceedToCheckoutButton;
@FindBy(id = "onepage-guest-register-button")
    private WebElementFacade continueButton;
@FindBy(id = "billing:firstname")
    private WebElementFacade firstNameField;
@FindBy(id = "billing:lastname")
    private WebElementFacade lastNameField;
@FindBy(id = "billing:email")
    private WebElementFacade emailField;
@FindBy(id = "billing:street1")
    private WebElementFacade addressField;
@FindBy(id = "billing:city")
    private WebElementFacade cityNameField;
@FindBy(id = "billing:region_id")
    private WebElementFacade stateDropdown;

    @Override
    public void selectFromDropdown(WebElement dropdown, String visibleLabel) {
        super.selectFromDropdown(dropdown, visibleLabel);
    }
}




