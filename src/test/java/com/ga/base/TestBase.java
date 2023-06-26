package com.ga.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties config=new Properties();
    public static Properties or=new Properties();
    public static FileInputStream fis;

    @BeforeSuite
    public void setUp(){
        if (driver==null){
            FileInputStream fis;

            try {

                fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/config.properties");
                config.load(fis);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            try {
                fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/OR.properties");
                or.load(fis);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            if (config.getProperty("browser").equals("chrome")){
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/executables/chromedriver");
                driver=new ChromeDriver();

            }
            driver.get(config.getProperty("testsiteurl"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);

        }
    }
    @AfterSuite
    public void tearDown(){
        if (driver!=null){
            driver.quit();
        }
    }
}
