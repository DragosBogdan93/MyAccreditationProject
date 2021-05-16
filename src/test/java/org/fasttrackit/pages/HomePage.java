package org.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://testfasttrackit.info/selenium-test/")
public class HomePage extends PageObject {

    @FindBy(css = ".skip-account .label")
    private WebElementFacade accountLink;

    @FindBy(css = "[title='Register']")
    private WebElementFacade registerLink;

    @FindBy(css = "[title='Log In']")
    private WebElementFacade logInLink;

    @FindBy(id = "search")
    private WebElementFacade searchField;

    @FindBy(css = "button[title='Search']")
    private WebElementFacade searchButton;

    public void clickRegisterLink() {
        clickOn(registerLink);
    }

    public void clickAccountLink(){
        clickOn(accountLink);
    }
    public void clickLogInLink(){
        clickOn(logInLink);
    }
    public void setSearchField(String text){
        typeInto(searchField,text);
    }
    public void clickSearch(){
        clickOn(searchButton);
    }

}
