package com.ga.testcases;

import com.ga.base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @Test
    public void LoginAsBankManager() throws InterruptedException {
        driver.findElement(By.cssSelector(or.getProperty("bmBtn"))).click();
        Thread.sleep(3000);
    }
}
