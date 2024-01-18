package Pages;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import static Pages.BasePage.getPropertyValue;

public class BaseTest {
    protected WebDriver driver;

    protected BasePage basePage;

    protected HomePage homePage;
    protected ShopPage shopPage;

    protected ProductPage productPage;

    protected BasketPage basketPage;
    protected CheckoutPage checkoutPage;

    protected OrderReceivedPage orderReceivedPage;
    public WebDriver getDriver(){
        String browser = getPropertyValue("browser");

        switch(browser){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
        }

        return driver;
    }

    @BeforeEach
    public void setup(){
        driver = getDriver();
        basePage = new BasePage(driver);
        homePage = new HomePage(driver);
        shopPage = new ShopPage(driver);
        productPage = new ProductPage(driver);
        basketPage = new BasketPage(driver);
        checkoutPage = new CheckoutPage(driver);
        orderReceivedPage = new OrderReceivedPage(driver);
        basePage.loadBaseUrl();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void after(){ driver.quit();}
}
