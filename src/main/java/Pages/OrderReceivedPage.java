package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderReceivedPage extends BasePage{

        By orderReceived = By.cssSelector(".woocommerce-thankyou-order-received");
        By paymentMethod = By.cssSelector(".method");

    public OrderReceivedPage(WebDriver driver){
        super(driver);
    }
}
