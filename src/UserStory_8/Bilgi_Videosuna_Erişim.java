package UserStory_8;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Bilgi_Videosuna_Erişim extends BaseDriver {

    @Test
    public void Test1() throws AWTException {
        driver.navigate().to("https://www.e-junkie.com/");

        Assert.assertTrue("Yanlış site",driver.getCurrentUrl().equals("https://www.e-junkie.com/"));


        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[onclick='toggleYoutubeModal(true)']")));
        WebElement SeeHowItWorks = driver.findElement(By.cssSelector("[onclick='toggleYoutubeModal(true)']"));
        SeeHowItWorks.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("GET IT NOW")));
        WebElement getItButon = driver.findElement(By.linkText("GET IT NOW"));
        getItButon.click();

        WebElement SignIn = driver.findElement(By.xpath("(//*[text()='Have an account? Sign In'])[1]"));
        SignIn.click();

        WebElement mail = driver.findElement(By.xpath("(//input[@name='username'])[1]"));
        mail.sendKeys("umityc72@gmail.com");

        WebElement password = driver.findElement(By.xpath("(//input[@name='password'])[1]"));
        password.sendKeys("123456789a");

        WebElement signUp = driver.findElement(By.xpath("//*[text()='Sign In']"));
        signUp.click();
        MyFunc.Bekle(3);

        driver.navigate().back();
        driver.navigate().back();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[onclick='toggleYoutubeModal(true)']")));
        WebElement SeeHowItWorks1 = driver.findElement(By.cssSelector("[onclick='toggleYoutubeModal(true)']"));
        SeeHowItWorks1.click();


        Actions driverAksiyon = new Actions(driver);

        for (int i = 0; i < 15; i++) { // 15 defa tab yapmak için döngüyü koydum
            driverAksiyon.sendKeys(Keys.TAB);
        }
        driverAksiyon.sendKeys(Keys.ENTER)
                .build()
                .perform();

        MyFunc.Bekle(15);



        BekleKapat();
    }
}