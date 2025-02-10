package util;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementHelper {
    private AppiumDriver driver;
    private WebDriverWait wait;
    private Actions action;

    public ElementHelper(AppiumDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.action = new Actions(driver);
    }

    public WebElement findElement(By key){
        return wait.until(ExpectedConditions.presenceOfElementLocated(key));
    }

    public void click(By key){
        findElement(key).click();
    }
    public void waitForElement(By key) {
        wait.until(ExpectedConditions.presenceOfElementLocated(key));
    }


    public void sendKeys(By key, String text){
        findElement(key).sendKeys(text);
    }

    public boolean isElementDisplayed(By key){
        return findElement(key).isDisplayed();
    }
}
