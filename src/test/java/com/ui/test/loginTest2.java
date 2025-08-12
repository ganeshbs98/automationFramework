package com.ui.test;

import com.ui.Utilis.TestBase;
import com.ui.Utilis.sampleClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class loginTest2 extends TestBase {

    @Test
    public void login() {
        System.out.println("testtttttt");
        browser().findElement(By.xpath("//a[contains(@title,'Log in to your' )]")).click();

    }
}
