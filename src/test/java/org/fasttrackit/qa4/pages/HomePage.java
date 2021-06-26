package org.fasttrackit.qa4.pages;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import java.util.List;

@DefaultUrl("http://qa4.fasttrackit.org:8008/")
public class HomePage extends PageObject {

    @FindBy(id = "menu-item-122")
    private WebElementFacade myAccountLink;
    @FindBy(css = ".header-search-button")
    private WebElementFacade searchIcon;
    @FindBy(css = "input[title='Search for:']")
    private WebElementFacade searchField;
    @FindBy(css = "input[value='Search']")
    private WebElementFacade searchSecondIcon;
    @FindBy(id = "menu-item-123")
    private WebElementFacade shopLink;
    @FindBy(id = "menu-item-125")
    private WebElementFacade checkoutLink;
    @FindBy(css = ".cart-contents")
    private WebElementFacade viewCartLink;
    @FindBy(css = "label .search-field")
    private WebElementFacade bottomSearchField;
    @FindBy(css = ".search-form .search-submit")
    private WebElementFacade searchBottomIcon;
    @FindBy(css = ".border-bottom-hover")
    private List<WebElementFacade> listSearch;
    @FindBy(css = ".page-title")
    private WebElementFacade resultNotFoundMessage;


    public void clickAccountLink() {
        clickOn(myAccountLink);
    }

    public void setSearchField(String value) {
        typeInto(searchField, value);
    }

    public void clickSearchIcon() {
        clickOn(searchIcon);
    }

    public void clickSecondSearchIcon() {
        clickOn(searchSecondIcon);
    }

    public void clickShopLink() {
        clickOn(shopLink);
    }

    public void clickViewCartLink() {
        waitABit(500);
        clickOn(viewCartLink);
    }

    public void pauseFor(Integer milliseconds) {
        waitABit(milliseconds);
    }

    public void clickCheckoutLink() {
        clickOn(checkoutLink);
    }

    public void setBottomSearchField(String text) {
        typeInto(bottomSearchField, text);
    }

    public void clickBottomSearchIcon() {
        clickOn(searchBottomIcon);
    }

    public boolean isProductInList(String productName) {
        for (WebElementFacade element : listSearch) {
            if (element.findElement(By.cssSelector(".entry-title"))
                    .getText().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }
    public boolean verifyMessageIsDisplay (String text) {
        return resultNotFoundMessage.containsOnlyText(text);
    }


}
