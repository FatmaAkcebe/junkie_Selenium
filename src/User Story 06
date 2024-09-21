package US06;
import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommunicationMessageSendingProcess extends BaseDriver {
    @Test
    public void test(){
        driver.get("https://shopdemo.fatfreeshop.com/?");
        MyFunc.Bekle(2);

        new Actions(driver)
                .scrollByAmount(0, 600)// verilen pixel miktarı kadar scroll yap
                .build()
                .perform();

        WebElement clickMe = driver.findElement(By.cssSelector("[class=ion-md-mail]"));
        clickMe.click();
        MyFunc.Bekle(2);

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sender_name")));//bu locator görünür olana kadar BEKLE
        WebElement name= driver.findElement(By.id("sender_name"));
        name.sendKeys("user");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sender_email")));//bu locator görünür olana kadar BEKLE
        WebElement email= driver.findElement(By.id("sender_email"));
        email.sendKeys("user@gmail.com");


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sender_subject")));//bu locator görünür olana kadar BEKLE
        WebElement message= driver.findElement(By.id("sender_subject"));
        message.sendKeys("The order does not appear");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sender_message")));//bu locator görünür olana kadar BEKLE
        WebElement subject= driver.findElement(By.id("sender_message"));
        subject.sendKeys("My order does not appear in the cart");

        WebElement clickSendMessage = driver.findElement(By.xpath("//*[text()='Send Message']"));
        clickSendMessage.click();
        MyFunc.Bekle(2);
        //su anda alert çıkmış oldu
        driver.switchTo().alert().accept();//// Alertin OK butonuna Tıklat
        BekleKapat();
    }
}
