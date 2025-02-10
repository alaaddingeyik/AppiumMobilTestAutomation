package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;


    public static Properties initialize_Properties() {
        if (properties == null) { // Eğer properties null ise yükle
            properties = new Properties();
            try {
                FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
                properties.load(fis);
                System.out.println("config.properties başarıyla yüklendi!");
            } catch (IOException e) {
                throw new RuntimeException("config.properties dosyası yüklenirken hata oluştu!", e);
            }
        }
        return properties;
    }


    public static String getProperty(String key) {
        if (properties == null) {
            initialize_Properties();
        }
        return properties.getProperty(key);
    }


    public static Properties getProperties() {
        if (properties == null) {
            initialize_Properties();
        }
        return properties;
    }
}
