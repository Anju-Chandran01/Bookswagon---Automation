package com.bz.bookswagon.qa.util;

import com.bz.bookswagon.qa.base.TestBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class TestUtil extends TestBase {
    public static long PAGE_LOAD_TIMEOUT = 180;
    public static long IMPLICIT_WAIT = 120;

//    public static void takeScreenshotAtEndOfTest() {
//        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        String currentDir = System.getProperty("user.dir");
//        try {
//            FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public void switchToFrame(){
        driver.switchTo().frame("cbox1663604928421");
    }
}
