package util;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    private AppiumDriver driver;

    @Before
    public void before() {
        System.out.println("Test Başlatılıyor...");
        driver = DriverFactory.initialize_Driver();
        System.out.println("Driver başarıyla başlatıldı!");
    }

    @After
    public void after() {
        if (driver != null) {
            driver.quit();
            System.out.println("Test Bitti. Driver kapatıldı.");
        } else {
            System.out.println("Driver zaten null, kapatma işlemi atlandı.");
        }
    }
}
