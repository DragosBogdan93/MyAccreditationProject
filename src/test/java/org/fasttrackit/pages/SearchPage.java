package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class SearchPage extends PageObject {
    @FindBy (css = ".product-name [href*='lafayette-convertible-dress.html']")
    private WebElementFacade productName;

    public void checkTheSearchResult (String message) {
        productName.shouldContainOnlyText(message);

    }
}
