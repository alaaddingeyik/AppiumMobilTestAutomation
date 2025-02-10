package util;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.time.Duration;

public class DriverFactory {

    private static AppiumDriver driver;

    public static AppiumDriver initialize_Driver() {
        if (driver == null) {
            try {
                Properties properties = new Properties();
                FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
                properties.load(fis);

                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName", properties.getProperty("platformName"));
                capabilities.setCapability("deviceName", properties.getProperty("deviceName"));
                capabilities.setCapability("appPackage", properties.getProperty("appPackage"));
                capabilities.setCapability("appActivity", properties.getProperty("appActivity"));
                capabilities.setCapability("app", properties.getProperty("app"));

                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

                System.out.println("Android Driver başarıyla başlatıldı!");

            } catch (MalformedURLException e) {
                throw new RuntimeException(" Appium sunucusuna bağlanırken hata oluştu!", e);
            } catch (IOException e) {
                throw new RuntimeException(" config.properties dosyası yüklenirken hata oluştu!", e);
            }
        }
        return driver;
    }

    public static AppiumDriver getDriver() {
        return driver;
    }
}
