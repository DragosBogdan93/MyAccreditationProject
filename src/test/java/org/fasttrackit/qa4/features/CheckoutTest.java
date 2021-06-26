package org.fasttrackit.qa4.features;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.qa4.steps.CheckoutSteps;
import org.fasttrackit.qa4.steps.HomeSteps;
import org.fasttrackit.qa4.steps.ProductSteps;
import org.fasttrackit.qa4.utils.BaseTest;
import org.junit.Test;

public class CheckoutTest extends BaseTest {

    @Steps
    private HomeSteps homeSteps;
    @Steps
    private CheckoutSteps checkoutSteps;
    @Steps
    private ProductSteps productSteps;

    @Test
    public void verifyCheckoutNotAvailableWithCartEmpty() {
        homeSteps.navigateToHomepage();
        homeSteps.clickCheckout();
        checkoutSteps.verifyInfoMessageIsDisplayed("Your cart is currently empty.");
    }

    @Test
    public void verifyAddingValidCoupon(){
        homeSteps.navigateToShop();
        productSteps.addProductToCart("Album");
        homeSteps.clickCheckout();
        checkoutSteps.clickEnterYourCode();
        checkoutSteps.enterCouponCode("Summer sale");
        checkoutSteps.clickApplyCoupon();
        checkoutSteps.verifyAppliedSuccessfully();
    }

    @Test
    public void verifyAddingInvalidCoupon() {
        homeSteps.navigateToShop();
        productSteps.addProductToCart("HOODIE WITH LOGO");
        homeSteps.clickCheckout();
        checkoutSteps.clickEnterYourCode();
        checkoutSteps.enterCouponCode("just a simple test");
        checkoutSteps.clickApplyCoupon();
        checkoutSteps.verifyErrorMessageIsDisplayed("just a simple test");
    }

    @Test
    public void checkCouponDiscountIsApplied() {
        homeSteps.navigateToShop();
        productSteps.addProductToCart("Album");
        homeSteps.clickCheckout();
        checkoutSteps.clickEnterYourCode();
        checkoutSteps.enterCouponCode("Summer sale");
        checkoutSteps.clickApplyCoupon();
        homeSteps.pauseFor(300);
        checkoutSteps.verifyCouponIsApply("Coupon: summer sale");
    }

    @Test
    public void placeAnOrder(){
        homeSteps.navigateToShop();
        productSteps.addProductToCart("Album");
        homeSteps.clickCheckout();
        checkoutSteps.enterCredentials("Dragos","Bogdan","Russia","Ulitsa Arkhitektora Vlasova, 15","Moskva","Districtul Federal Central",117335,79585675297L,"dragos.bogdan101010@gmail.com");
        checkoutSteps.clickPlaceOrder();
        homeSteps.pauseFor(2000);
        checkoutSteps.isTheOrderPlaced("Thank you. Your order has been received.");

    }
}

