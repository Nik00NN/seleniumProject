package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShopPage extends BasePage{



    By dropdownSortBooksBy = By.name("orderby");

    By masteringJavascriptBook = By.cssSelector("img[title='Mastering JavaScript']");

    public ShopPage(WebDriver driver){
        super(driver);

    }

    public String sortProductsByAverageRatingAndGetUrl(){
        Select selectByRating = new Select(find(dropdownSortBooksBy));
        selectByRating.selectByValue("rating");
        String url = driver.getCurrentUrl();
        return url;

    }
    public ProductPage clickOnMasteringJavascriptBook(){
        click(masteringJavascriptBook);
        return new ProductPage(driver);
    }

}
