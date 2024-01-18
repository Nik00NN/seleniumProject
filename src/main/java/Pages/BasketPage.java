package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends BasePage {

    By proceedToCheckoutButton = By.cssSelector(".checkout-button.button.alt.wc-forward");

    public BasketPage(WebDriver driver){
        super(driver);
    }

    public float getTotalOrSubtotalAsFloats(String TotalOrSubtotal){
        By totalOrSubtotal = By.cssSelector(".cart_totals .shop_table  [data-title='"+TotalOrSubtotal+"']");
        Float number = Float.parseFloat(find(totalOrSubtotal).getText().replace("₹",""));
        return number;
    }

    public CheckoutPage proceedToCheckout(){
        click(proceedToCheckoutButton);
        return new CheckoutPage(driver);
    }


}
