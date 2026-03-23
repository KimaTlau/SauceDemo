package com.saucedemo.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

    Properties pro;

    public ConfigDataProvider() {

        File src = new File("./Config/config.properties");

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

    public String getMailHost() {
        return pro.getProperty("mail.smtp.host");
    }

    public String getMailPort() {
        return pro.getProperty("mail.smtp.port");
    }

    public String getMailFrom() {
        return pro.getProperty("mail.from");
    }

    public String getMailPassword() {
        return pro.getProperty("mail.password");
    }

    public String getMailTo() {
        return pro.getProperty("mail.to");
    }

    public String getMailAuth() {
        return pro.getProperty("mail.smtp.auth");
    }

    public String getMailStartTLS() {
        return pro.getProperty("mail.smtp.starttls.enable");
    }
}
