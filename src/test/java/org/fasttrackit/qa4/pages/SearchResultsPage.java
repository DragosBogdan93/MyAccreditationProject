package org.fasttrackit.qa4.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class SearchResultsPage extends PageObject {

    @FindBy(css = "li.product")
    private List<WebElementFacade> listOfProducts;
    @FindBy(css = "select.orderby")
    private WebElementFacade sortByDropdown;
    @FindBy(css = ".woocommerce-info")
    private WebElementFacade productNotFoundMessage;


    public boolean isProductInList(String productName) {
        for (WebElementFacade element : listOfProducts) {
            if (element.findElement(By.cssSelector(".products h2"))
                    .getText().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public void setSortByDropdown(String value) {
        sortByDropdown.selectByVisibleText(value);
    }

    public boolean isSortByPriceAscending() {
        int firstPrice = getPriceFromProduct(listOfProducts.get(0));
        int secondPrice = getPriceFromProduct(listOfProducts.get(listOfProducts.size() - 1));
        return firstPrice <= secondPrice;
    }

    private int getPriceFromProduct(WebElementFacade element) {
        return Integer.parseInt(element.find(By.cssSelector(".price")).getText().replaceAll(",00 lei", ""));
    }

    public void verifyMessageIsDisplay() {
        String page = getDriver().getPageSource();
        boolean hasMessage = page.contains("No products were found matching your selection.");
        Assert.assertTrue(hasMessage);

    }
}
