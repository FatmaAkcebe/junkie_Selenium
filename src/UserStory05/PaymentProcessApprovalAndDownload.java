package UserStory05;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

public class PaymentProcessApprovalAndDownload extends BaseDriver {
    @Test
    public void Test1() throws AWTException, IOException {

        driver.get("https://shopdemo.fatfreeshop.com/?");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='EJProduct_1597355']/.././following-sibling::div/a/div/div/following-sibling::div/button")));
        WebElement element1 = driver.findElement(By.xpath("//*[@id='EJProduct_1597355']/.././following-sibling::div/a/div/div/following-sibling::div/button"));
        element1.click();

        MyFunc.Bekle(2);

        WebElement frame = driver.findElement(By.xpath("//*[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(frame);
        WebElement element2 = driver.findElement(By.xpath("//*[@class='Payment-Button CC']"));
        element2.click();


        WebElement mail = driver.findElement(By.xpath("//*[@placeholder='Email']"));
        mail.sendKeys("techno.study5@gmail.com");

        WebElement mailconfirm = driver.findElement(By.xpath("//*[@placeholder='Confirm Email']"));
        mailconfirm.sendKeys("techno.study5@gmail.com");

        WebElement nameoncard = driver.findElement(By.xpath("//*[@placeholder='Name On Card']"));
        nameoncard.sendKeys("TeamBes");

        WebElement phone = driver.findElement(By.xpath("//*[@class='Billing-Phone Inline']/input"));
        phone.sendKeys("555555555");

        WebElement company = driver.findElement(By.xpath("//*[@class='Billing-Company']/input"));
        company.sendKeys("Techno Study");

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        MyFunc.Bekle(2);

        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        MyFunc.Bekle(2);

        for (int i = 0; i < 8; i++) {

            robot.keyPress(KeyEvent.VK_4);
            robot.keyRelease(KeyEvent.VK_4);
            robot.keyPress(KeyEvent.VK_2);
            robot.keyRelease(KeyEvent.VK_2);
        }

        MyFunc.Bekle(2);

        robot.keyPress(KeyEvent.VK_1);
        robot.keyRelease(KeyEvent.VK_1);
        robot.keyPress(KeyEvent.VK_2);
        robot.keyRelease(KeyEvent.VK_2);

        robot.keyPress(KeyEvent.VK_2);
        robot.keyRelease(KeyEvent.VK_2);
        robot.keyPress(KeyEvent.VK_4);
        robot.keyRelease(KeyEvent.VK_4);


        for (int i = 0; i < 3; i++) {
            robot.keyPress(KeyEvent.VK_0);
            robot.keyRelease(KeyEvent.VK_0);
        }

        MyFunc.Bekle(2);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        WebElement paybutton = driver.findElement(By.xpath("//*[@class='Pay-Button']"));
        paybutton.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='download_btn top10']")));
        WebElement downloadbutton = driver.findElement(By.xpath("//*[@class='download_btn top10']"));
        downloadbutton.click();
        MyFunc.Bekle(2);

        WebElement element3=driver.findElement(By.xpath("//*[@class='product_name']"));
        Assert.assertTrue("Yanlış Ürün", element3.getText().contains("Demo"));

        WebElement element4=driver.findElement(By.xpath("//*[@class='all_text content_head2']"));
        Assert.assertNotNull(element4);

        WebElement element5=driver.findElement(By.xpath("//*[@class='green_text_margin']"));
        Assert.assertTrue("Order Confirmation is not ok", element5.getText().contains("is confirmed"));


    }
}
