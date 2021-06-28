package org.fasttrackit.qa4.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import java.util.List;

public class CartPage extends PageObject {

    @FindBy(css = ".cart tbody .cart_item")
    private List<WebElementFacade> listProductsFromCart;
    @FindBy(css = ".remove")
    private List<WebElementFacade> listRemoveButtons;
    @FindBy(css = ".cart-empty")
    private WebElementFacade successEmptyCartMessage;
    @FindBy(css = ".product-subtotal .amount")
    private List<WebElementFacade> listOfPrices;
    @FindBy(css = ".order-total strong")
    private WebElementFacade grandTotalPrice;
    @FindBy(css = ".shipping td :first-child")
    private WebElementFacade taxPrice;
    @FindBy(css = "tbody :first-child .product-quantity input")
    private WebElementFacade firstQuantityField;
    @FindBy(css = "tbody :nth-child(2) .product-quantity input")
    private WebElementFacade secondQuantityField;
    @FindBy(css = "tbody :nth-child(3) .product-quantity input")
    private WebElementFacade thirdQuantityField;
    @FindBy(css = ".button[name=update_cart]")
    private WebElementFacade updateCartButton;
    @FindBy(css = ".woocommerce-message")
    private WebElementFacade successUpdateCartMessage;

    public void setFirstQuantityField(int firstQuantity) {
        firstQuantityField.clear();
        typeInto(firstQuantityField, String.valueOf(firstQuantity));
    }

    public void setSecondQuantityField(int secondQuantity) {
        secondQuantityField.clear();
        typeInto(secondQuantityField, String.valueOf(secondQuantity));
    }

    public void setThirdQuantityField(int thirdQuantity) {
        thirdQuantityField.clear();
        typeInto(thirdQuantityField, String.valueOf(thirdQuantity));
    }

    public void clickUpdateCartButton() {
        clickOn(updateCartButton);
    }

    public boolean isProductInCart(String productName) {
        for (WebElementFacade element : listProductsFromCart) {
            if (element.findElement(By.cssSelector(".product-name a")).getText().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public void removeProductsFromCart() {
        for (int i = 0; i < listRemoveButtons.size(); ) {
            listRemoveButtons.get(i).click();
            waitABit(2000);
        }
    }

    public void successEmptyCartMessage() {
        successEmptyCartMessage.shouldContainOnlyText("Your cart is currently empty.");
    }

    public int getProductPricesCombined() {
        int priceTotalCalculated = 0;
        for (WebElementFacade element : listOfPrices) {
            priceTotalCalculated += getPriceFromElementCart(element);
        }
        return priceTotalCalculated;
    }

    private int getPriceFromElementCart(WebElementFacade elementFacade) {
        return Integer.parseInt(elementFacade.getText().replaceAll(" lei", "").replaceAll(",", ""));
    }

    public int getGrandTotalPriceInt() {
        return getPriceFromElementCart(grandTotalPrice);
    }

    public int getTaxPriceInt() {
        return getPriceFromElementCart(taxPrice);
    }

    public boolean isCarTotalCalculatedCorrectly() {
        return (getProductPricesCombined() + getTaxPriceInt()) == getGrandTotalPriceInt();
    }

    public void verifySuccessUpdateCartMessage() {
        successUpdateCartMessage.shouldContainText("Cart updated.");
    }


}