package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BasePage {

        protected WebDriver driver;

        static FileReader fileReader;

        static Properties properties = new Properties();

        protected WebDriverWait wait;

        int timeoutSec = 10;

        public BasePage(WebDriver driver){
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSec));
        }

        public static String getPropertyValue(String key){

            try{
                fileReader = new FileReader("src/main/resources/app.properties");
                properties.load(fileReader);
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
            return properties.getProperty(key);
        }

        public void loadBaseUrl(){
            String url = getPropertyValue("url");
            driver.get(url);
        }

        public String getBrowser(){return getPropertyValue("browser");}
        public WebElement find(By element){ return driver.findElement(element); }
        public void type(By element,String text) { find(element).sendKeys(text); }
        public void click(By element){ find(element).click(); }
        public String getText(By element) { return find(element).getText(); }

        public boolean isDisplayed(By element){
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
            return true;
        }


        public void goToPage(String pageUrlKey){
            String url = getPropertyValue(pageUrlKey);
            driver.navigate().to(url);
        }



}
