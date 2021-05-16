package org.fasttrackit.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;


public class CartPage extends PageObject {


    @FindBy (css = "a[href*='sale.html'].level0")
    private WebElementFacade saleLink;


@FindBy (css = "[href*='slim-fit-dobby-oxford-shirt-572.html'].button")

    private WebElementFacade productLink;

@FindBy (css = ".add-to-cart-buttons .button.btn-cart")
    private WebElementFacade addToCartButton;

@FindBy (id = "option27")
    private WebElementFacade colorButton;

@FindBy (id = "option81")
private WebElementFacade sizeButton;

@FindBy (css = ".success-msg span")
private WebElementFacade successMessageParagraph;

public void clickSaleLink() {
    clickOn(saleLink);
}
public void clickProductLink() {
    clickOn(productLink);
}
public void clickAddToCartButton() {
    clickOn(addToCartButton);
}
public void clickColorButton() {
    clickOn(colorButton);
}
public void clickSizeButton() {
    clickOn(sizeButton);
}
public void checkProductIsInTheCart (String message) {
    successMessageParagraph.shouldContainOnlyText(message);
}
}
