package Pages;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class BasketTest extends BaseTest{

        @Test
        public void testIfTotalIsGreaterThanSubtotal() {
            productPage.addBookToBasket();
            productPage.viewBasket();
            assertTrue(basketPage.isDisplayed(basketPage.proceedToCheckoutButton));
            assertTrue(basketPage.getTotalOrSubtotalAsFloats("Total")> basketPage.getTotalOrSubtotalAsFloats("Subtotal"));
        }

        @Test
        public void testProceedToCheckout(){
            productPage.addBookToBasket();
            productPage.viewBasket();
            assertTrue(basketPage.isDisplayed(basketPage.proceedToCheckoutButton));
            basketPage.proceedToCheckout();
            assertTrue(checkoutPage.isDisplayed(checkoutPage.placeOrderButton));
        }
}
