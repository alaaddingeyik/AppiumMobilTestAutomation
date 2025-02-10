package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import util.ElementHelper;
import org.openqa.selenium.By;

public class AkakceHomePage {
    private final ElementHelper elementHelper;


    private By searchIcon = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.akakce.akakce:id/searchbtnmain\")");
    private By searchBox = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.akakce.akakce:id/searcheditttext\")");
    private By filterButton = AppiumBy.androidUIAutomator("new UiSelector().text(\"Filtrele\")");
    private By categoryOption = AppiumBy.androidUIAutomator("new UiSelector().text(\"Bilgisayar, Donanım\")");
    private By viewProductsButton = AppiumBy.androidUIAutomator("new UiSelector().text(\"Ürünleri Gör\")");
    private By sortingOption = AppiumBy.androidUIAutomator("new UiSelector().text(\"En Yüksek Fiyat\")");
    private By productItem = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\").instance(9)");
    private By goToProductButton = AppiumBy.androidUIAutomator("new UiSelector().text(\"Ürüne Git\")");
    private By goToSellerButton = AppiumBy.androidUIAutomator("new UiSelector().text(\"Satıcıya Git\")");

    public AkakceHomePage(AppiumDriver driver) {
        this.elementHelper = new ElementHelper(driver);
    }

    public void clickSearchIcon() {
        System.out.println("Arama ikonuna tıklanmadan önce bekleniyor...");
        elementHelper.waitForElement(searchIcon);

        if (elementHelper.isElementDisplayed(searchIcon)) {
            System.out.println("Arama ikonu bulundu, tıklanıyor...");
            elementHelper.click(searchIcon);
        } else {
            System.out.println("Arama ikonu bulunamadı!");
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" Arama ikonuna tıklama tamamlandı.");
    }

    public void enterSearchText(String text) {
        System.out.println("Arama kutusuna '" + text + "' yazılıyor...");
        elementHelper.waitForElement(searchBox);
        elementHelper.click(searchBox);
        elementHelper.sendKeys(searchBox, text);
        System.out.println("Arama kutusuna yazma işlemi tamamlandı.");
    }

    public void clickFilterButton() {
        elementHelper.click(filterButton);
    }

    public void selectCategory() {
        elementHelper.click(categoryOption);
    }

    public void clickViewProductsButton() {
        elementHelper.click(viewProductsButton);
    }

    public void selectSortingOption() {
        elementHelper.click(sortingOption);
    }

    public void clickProductItem() {
        elementHelper.click(productItem);
    }

    public void clickGoToProductButton() {
        elementHelper.click(goToProductButton);
    }

    public void clickGoToSellerButton() {
        elementHelper.click(goToSellerButton);
    }

    public boolean isGoToSellerButtonDisplayed() {
        return elementHelper.isElementDisplayed(goToSellerButton);
    }
}
