package com.ga.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    public static void main(String[] args) throws IOException {
        Properties config=new Properties();
        Properties or=new Properties();
        FileInputStream fis;

        fis = new FileInputStream("/Users/pendemsujithkumar/IdeaProjects/DataDrivenProjectGA/src/test/resources/properties/config.properties");
        config.load(fis);
        fis = new FileInputStream("/Users/pendemsujithkumar/IdeaProjects/DataDrivenProjectGA/src/test/resources/properties/OR.properties");
        System.out.println(config.getProperty("browser"));
        or.load(fis);
        System.out.println(or.getProperty("bmBtn"));

    }
}
