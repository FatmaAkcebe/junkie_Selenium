
package UserStory_1;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InvalidPromotionalCode extends BaseDriver {
    @Test
    public void Test1() {

        String promoCode = "12121212";

        driver.get("https://shopdemo.fatfreeshop.com/");
        wait.until(ExpectedConditions.urlToBe("https://shopdemo.fatfreeshop.com/"));

        // • Find "Demo Ebook" on the homepage or related product page.and Confirm success message
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='column all_tag']//*[text()='Ebook'] ")));
        WebElement ebookButton = driver.findElement(By.xpath("//div[@class='column all_tag']//*[text()='Ebook'] "));
        wait.until(ExpectedConditions.elementToBeClickable(ebookButton));
        MyFunc.javaScriptClick(ebookButton);
        Assert.assertTrue("Failed to proceed to the Ebook page", driver.getCurrentUrl().contains("/Ebook"));

        //" Click on the "Add Demo E-Book to Cart" button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='view_product']")));
        WebElement addToCartButton = driver.findElement(By.cssSelector("[class='view_product']"));
        MyFunc.scrollElement(addToCartButton);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        MyFunc.javaScriptClick(addToCartButton);
        MyFunc.Bekle(2);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']")));
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Demo eBook'])[1]")));
        WebElement demoEbookControl = driver.findElement(By.xpath("(//*[text()='Demo eBook'])[1]"));
        Assert.assertTrue("‘Demo eBook’ could not be added to the basket.", demoEbookControl.getText().contains("eBook"));

        // "Click on the "Add Promo Code" button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='Actions']//button)[2]")));
        WebElement addPromoCode = driver.findElement(By.xpath("(//div[@class='Actions']//button)[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(addPromoCode));
        MyFunc.javaScriptClick(addPromoCode);

        // Enter an invalid promo code
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='Promo-Code-Value']")));
        WebElement promoCodeBox = driver.findElement(By.xpath("//input[@class='Promo-Code-Value']"));
        promoCodeBox.sendKeys(promoCode);

        // Click on the "Apply" button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Promo-Box Active']//button")));
        WebElement applyButton = driver.findElement(By.xpath("//div[@class='Promo-Box Active']//button"));
        wait.until(ExpectedConditions.elementToBeClickable(applyButton));
        MyFunc.javaScriptClick(applyButton);

        // Verify "Invalid promo code" warning message
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='SnackBar']//span")));
        WebElement invalidCodeMessage = driver.findElement(By.xpath("//div[@id='SnackBar']//span"));
        Assert.assertTrue("Valid promo code", invalidCodeMessage.getText().contains("Invalid"));

        BekleKapat();
        driver.quit();
    }

}
