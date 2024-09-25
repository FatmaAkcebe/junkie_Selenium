package UserStory_2;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class _02_FaultyPayment extends BaseDriver {

    @Test
    public void Test1(){

        driver.get("https://shopdemo.fatfreeshop.com/?");
        MyFunc.Bekle(3);


        WebElement sepet= driver.findElement(By.cssSelector("[onclick='return EJEJC_lc(this);'][class='navbar-item cart']"));
        sepet.click();

        WebElement iFrame= driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iFrame);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Your Cart is empty']")));
        WebElement sepetControl= driver.findElement(By.xpath("//h3[text()='Your Cart is empty']"));
        System.out.println("sepetKontrol.getText() = " + sepetControl.getText());

        Assert.assertTrue("sepet boş değil",sepetControl.getText().equalsIgnoreCase("Your Cart is empty"));

        WebElement continueShopping= driver.findElement(By.xpath("//*[text()='Continue Shopping']"));
        continueShopping.click();

        driver.switchTo().defaultContent();
        WebElement eBook= driver.findElement(By.cssSelector("[onclick*='1595015']"));
        eBook.click();

        driver.switchTo().frame(iFrame);

        WebElement sepetControl2=driver.findElement(By.xpath("//*[@class='Col2 Product-Desc']/h5"));
        System.out.println("sepetControl2.getText() = " + sepetControl2.getText());


        Assert.assertTrue("sepete ürün eklenmemiş",sepetControl2.getText().equalsIgnoreCase("Demo eBook"));

        WebElement creditCard= driver.findElement(By.xpath("//*[@class='Payment-Options']/button[3]  "));
        creditCard.click();


        WebElement pay= driver.findElement(By.cssSelector("div[data-processor='TripleA']+button"));
        pay.click();

        WebElement mesaj=driver.findElement(By.xpath("//span[text()='Invalid Billing Name']"));
        System.out.println("mesaj.getText() = " + mesaj.getText());

        String mesajText = mesaj.getText();
        Assert.assertTrue("Geçerli bir mail adresi veya geçerli fatura bilgileri giriniz",
                mesajText.contains("Invalid Email") || mesajText.contains("Invalid Billing"));


        BekleKapat();


    }
}
