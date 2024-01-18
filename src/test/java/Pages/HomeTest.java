package Pages;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class HomeTest extends BaseTest {

    @Test
    public void testThreeNewArrivalsAndGoToShopPage(){
        assertTrue(homePage.threeNewArrivals(),"New Arrivals section does not have only 3 books");
        shopPage = homePage.goToShop();
        assertTrue(shopPage.isDisplayed(shopPage.dropdownSortBooksBy));
    }

}
