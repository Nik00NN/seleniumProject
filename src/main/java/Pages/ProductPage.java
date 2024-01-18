package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {

    By addToBasketButton = By.xpath("//button[normalize-space()='Add to basket']");
    By viewBasketButton = By.xpath("//a[normalize-space()='View Basket']");
    public ProductPage(WebDriver driver){
        super(driver);
    }

    public void addBookToBasket(){
        goToPage("bookUrl");
        click(addToBasketButton);
    }

    public BasketPage viewBasket(){
     click(viewBasketButton);
     return new BasketPage(driver);
    }

}
