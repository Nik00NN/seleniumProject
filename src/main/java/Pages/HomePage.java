package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage{
        By shopButton = By.linkText("Shop");

        public HomePage(WebDriver driver){
            super(driver);
        }

        public boolean threeNewArrivals(){
            List<WebElement> books =driver.findElements(By.xpath("//*[contains(@class, 'products')]"));
            return books.size() == 3;
        }

        public ShopPage goToShop(){
            click(shopButton);
            return new ShopPage(driver);
        }




}
