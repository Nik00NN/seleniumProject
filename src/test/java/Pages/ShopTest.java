package Pages;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;


public class ShopTest extends BaseTest{

   @Test
    public void testSortByAverageRatingAndClickOnMasteringJavascriptBook(){
       shopPage = homePage.goToShop();
       assertTrue(shopPage.isDisplayed(shopPage.dropdownSortBooksBy));
       assertEquals("https://practice.automationtesting.in/shop/?orderby=rating",shopPage.sortProductsByAverageRatingAndGetUrl());
       productPage = shopPage.clickOnMasteringJavascriptBook();
       assertTrue(productPage.isDisplayed(productPage.addToBasketButton));
   }
}