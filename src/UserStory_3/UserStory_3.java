package UserStory_3;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class UserStory_3 extends BaseDriver {

    @Test
    public void Tess1(){

        driver.get("https://shopdemo.fatfreeshop.com/?");

        WebElement AddToCard=driver.findElement(By.xpath("(//button[contains(@onclick, 'EJProductClick')])[2]"));
        AddToCard.click();
        MyFunc.Bekle(2);

        WebElement iframe = driver.findElement(By.xpath("//iframe[contains(@class, 'EJIframeV3 EJOverlayV3')]"));
        driver.switchTo().frame(iframe);


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='Payment-Button CC']")));
        WebElement debitCard=driver.findElement(By.xpath("//button[@class='Payment-Button CC']"));
        debitCard.click();
        MyFunc.Bekle(2);


        
        WebElement email = driver.findElement(By.xpath("//*[@placeholder='Email' and @type='email' and @autocomplete='email']"));
        email.sendKeys("techno.study5@gmail.com");
        MyFunc.Bekle(1);

        WebElement nameOnCard = driver.findElement(By.xpath("//*[@placeholder='Name On Card']"));
        nameOnCard.sendKeys("TeamBes");
        MyFunc.Bekle(1);

        WebElement confirm_email = driver.findElement(By.xpath("//input[@placeholder='Confirm Email']"));
        confirm_email.sendKeys("techno.study5@gmail.com");
        MyFunc.Bekle(1);

        WebElement iframe1 = driver.findElement(By.xpath("//iframe[contains(@name, 'privateStripeFrame')]"));
        driver.switchTo().frame(iframe1);
        MyFunc.Bekle(2);

        WebElement cardNumber = driver.findElement(By.xpath("//input[contains(@placeholder, 'Kart numarası')]"));
        cardNumber.sendKeys("1111 1111 1111 1111");


        WebElement message=driver.findElement(By.xpath("//div[@id='SnackBar']"));
        wait.until(ExpectedConditions.visibilityOf(message));
        Assert.assertTrue(message.getText().contains("Kart numaranız geçersiz."));




        BekleKapat();


        
    }
}
