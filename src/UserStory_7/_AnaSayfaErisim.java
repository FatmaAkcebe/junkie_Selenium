package UserStory_7;

import Utlity.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class _AnaSayfaErisim extends BaseDriver {
    @Test
    public void Test1(){
        driver.get("https://demowebshop.tricentis.com");
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();

        // Sayfa yüklenene kadar bekleyin
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("register-button")));

        // "Register" butonuna tıklayın (Test için örnek, gerçek kaydı denemeyin)
        WebElement registerButton = driver.findElement(By.id("register-button"));
        registerButton.click();

        // Sayfanın doğru yüklenip yüklenmediğini doğrulayın
        String expectedUrl = "https://demowebshop.tricentis.com/register";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("URL beklenenden farklı", expectedUrl, actualUrl);
    }


    }



