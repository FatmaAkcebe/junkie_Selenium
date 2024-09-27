package Utlity;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class MyFunc {

    public static void Bekle(int sn){

        try {
            Thread.sleep(sn*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void scrollElement(WebElement element) {
        JavascriptExecutor javaScript = (JavascriptExecutor) BaseDriver.driver;
        javaScript.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void javaScriptClick(WebElement element) {
        JavascriptExecutor javaScript = (JavascriptExecutor) BaseDriver.driver;
        javaScript.executeScript("arguments[0].click();", element);
    }
}
