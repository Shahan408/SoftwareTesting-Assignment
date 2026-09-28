package framework.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();


    static {
        String filePath = "src/test/resources/config.properties";

        try {
            FileInputStream file = new FileInputStream(filePath);
            properties.load(file);
            file.close();

        } catch (IOException e) {
            throw new RuntimeException(
                    "Could not find config.properties" + e
            );
        }
    }

    public static String get(String key) {
        String value = properties.getProperty(key);

        if (value == null) {
            throw new RuntimeException(
                    "Key  not found in config.properties. ");
        }
        return value;
    }
}