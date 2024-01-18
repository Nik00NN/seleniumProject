package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {

    By placeOrderButton = By.id("place_order");
    By firstNameInput = By.id("billing_first_name");
    By lastNameInput  = By.id("billing_last_name");
    By emailInput = By.id("billing_email");
    By phoneInput = By.id("billing_phone");

    By streetAddressInput = By.id("billing_address_1");
    By townInput = By.id("billing_city");
    By stateInput =By.id("billing_state");
    By postcodeInput = By.id("billing_postcode");


    By cashOnDeliveryRadioButton = By.id("payment_method_cod");

    public CheckoutPage(WebDriver driver){
        super(driver);
    }

    private JavascriptExecutor js = (JavascriptExecutor) driver;

    public OrderReceivedPage fillCheckoutInputsAndBuy(){
        type(firstNameInput,getPropertyValue("firstName"));
        type(lastNameInput,getPropertyValue("lastName"));
        type(emailInput,getPropertyValue("email"));
        type(phoneInput,getPropertyValue("phone"));
        type(streetAddressInput,getPropertyValue("streetAddress"));
        type(townInput,getPropertyValue("town"));
        if(ifStateInputIsText()){type(stateInput,getPropertyValue("state"));}
        type(postcodeInput,getPropertyValue("postcode"));
        js.executeScript("window.scrollBy(0,750)","");
        wait.until(ExpectedConditions.elementToBeClickable(cashOnDeliveryRadioButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton)).click();
        return new OrderReceivedPage(driver);
    }

    private boolean ifStateInputIsText(){
      return find(stateInput).getAttribute("type") == "text";
    }

}
