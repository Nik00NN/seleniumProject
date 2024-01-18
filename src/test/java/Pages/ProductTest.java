package Pages;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
public class ProductTest extends BaseTest {

    @Test
    public void testAddProductToBasketAndViewBasket(){
        productPage.addBookToBasket();
        assertTrue(productPage.isDisplayed(productPage.viewBasketButton));
        basketPage = productPage.viewBasket();
        assertTrue(basketPage.isDisplayed(basketPage.proceedToCheckoutButton));
    }
}
