package Pages;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.*;

public class CheckoutTest extends BaseTest {

        @Test
        public void successfulCheckout() throws InterruptedException {
           productPage.addBookToBasket();
           assertTrue(productPage.isDisplayed(productPage.viewBasketButton));
           basketPage = productPage.viewBasket();
           assertTrue(basketPage.isDisplayed(basketPage.proceedToCheckoutButton));
           checkoutPage = basketPage.proceedToCheckout();
           assertTrue(checkoutPage.isDisplayed(checkoutPage.placeOrderButton));
           orderReceivedPage = checkoutPage.fillCheckoutInputsAndBuy();
           assertTrue(orderReceivedPage.isDisplayed(orderReceivedPage.paymentMethod));
           assertEquals("Thank you. Your order has been received.",orderReceivedPage.getText(orderReceivedPage.orderReceived));
        }


}
