package com.FbUtils.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    public static long wait=60;
    public static RemoteWebDriver driver;

    public static boolean isElementVisible(WebElement element)
    {
        try{
            if(element.isDisplayed())
                return true;
            return false;
        }
        catch (org.openqa.selenium.NoSuchElementException e)
        {
            return false;
        }

    }


    public static void waitUntilElementIsVisible(WebElement element) {
        WebDriverWait wwait = new WebDriverWait(driver, wait);

        wwait.until(ExpectedConditions.visibilityOf(element));
    }




    public static void sleep(int timeout){
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
