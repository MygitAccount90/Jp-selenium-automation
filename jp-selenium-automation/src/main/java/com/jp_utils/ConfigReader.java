package com.jp_utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    static {
        try {
            prop = new Properties();

            InputStream is = ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream("config.properties");

            if (is == null) {
                throw new RuntimeException("config.properties file not found in classpath");
            }

            prop.load(is);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties file.", e);
        }
    }

    public static String getProperty(String key) {
        String value = prop.getProperty(key);
        if (value == null) {
            throw new RuntimeException(
                    "Property '" + key + "' not found in config.properties");
        }
        return value;
    }
}
