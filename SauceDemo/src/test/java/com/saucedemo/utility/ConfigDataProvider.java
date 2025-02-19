package com.saucedemo.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

    Properties pro;

    public ConfigDataProvider() {

        File src = new File("src/Config/config.properties");

        try {
            FileInputStream fis = new FileInputStream(src);

            pro = new Properties();

            pro.load(fis);
        } catch (Exception e) {
            System.out.println("Not able to load Config File" +e.getMessage());
        }
    }

    public String getUrl() {
        return pro.getProperty("url");
    }
}
