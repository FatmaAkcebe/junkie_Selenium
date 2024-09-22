package UserStory_4;

import Utlity.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Utlity.BaseDriver.BekleKapat;
import static Utlity.BaseDriver.driver;

public class Payment_and_confirmation_by_Debit_Credit_Card {
    @Test
    public void Test4() {

        //TODO  Navigate to the  https://shopdemo.e-junkie.com/
        driver.get("https://shopdemo.e-junkie.com/");

        //TODO  Check if Demo eBook can be seen on the screen
        WebElement add_to_cart = driver.findElement(By.xpath("(//button[contains(@onclick, 'EJProductClick')])[2]"));
        System.out.println("add_to_cart_displayed.isDisplayed() = " + add_to_cart.isDisplayed());

        Assert.assertTrue(add_to_cart.isDisplayed() == true);
        MyFunc.Bekle(2);

        //TODO Click on the add to cart button of Demo eBook.
        add_to_cart.click();
        MyFunc.Bekle(2);

        //TODO Click on "Pay using Debit / Credit Card" section.
        WebElement iframe = driver.findElement(By.xpath("//iframe[contains(@class, 'EJIframeV3 EJOverlayV3')]"));
        driver.switchTo().frame(iframe);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement pay_debit_card = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='Payment-Button CC']")));
        pay_debit_card.click();

        //TODO Check if name, e-mail and card informations placeholders are displayed on the screen
        WebElement email = driver.findElement(By.xpath("//*[@placeholder='Email' and @type='email' and @autocomplete='email']"));
        System.out.println("email.isDisplayed() = " + email.isDisplayed());

        Assert.assertTrue(email.isDisplayed() == true);

        WebElement name_on_card = driver.findElement(By.xpath("//*[@placeholder='Name On Card']"));
        System.out.println("name_on_card.isDisplayed() = " + name_on_card.isDisplayed());

        Assert.assertTrue(name_on_card.isDisplayed() == true);

        WebElement new_frame = driver.findElement(By.xpath("//iframe[contains(@name, 'privateStripeFrame')]"));
        driver.switchTo().frame(new_frame);
        MyFunc.Bekle(2);

        WebElement card_number = driver.findElement(By.xpath("//input[contains(@placeholder, 'Kart numarası')]"));
        System.out.println("card_number.isDisplayed() = " + card_number.isDisplayed());
        Assert.assertTrue(card_number.isDisplayed() == true);

        //TODO Insert the Credit card informations on the placeholder
        //TODO   Insert the email and name on the email and name placeholders

        driver.switchTo().parentFrame();
        MyFunc.Bekle(2);
        email.sendKeys("techno.study5@gmail.com");
        WebElement confirm_email = driver.findElement(By.xpath("//input[@placeholder='Confirm Email']"));
        confirm_email.sendKeys("techno.study5@gmail.com");
        name_on_card.sendKeys("TeamBes");

        MyFunc.Bekle(2);
        driver.switchTo().frame(1);
        card_number.sendKeys("4242 4242 4242 4242");
        MyFunc.Bekle(1);
        WebElement card_expire = driver.findElement(By.xpath("(//span[@class='InputContainer'])[2]/input"));
        card_expire.sendKeys("1224");
        MyFunc.Bekle(1);
        WebElement card_cvc = driver.findElement(By.xpath("(//span[@class='InputContainer'])[3]/input"));
        card_cvc.sendKeys("000");
        MyFunc.Bekle(1);

        //TODO  Click the Pay button

        driver.switchTo().parentFrame();
        MyFunc.Bekle(2);
        WebElement pay_button = driver.findElement(By.xpath("//button[@type='button' and contains(@class, 'Pay-Button') and text()='Pay 0.50 USD']"));
        pay_button.click();
        driver.switchTo().defaultContent();

        //TODO Display the "your order is confirmed. Thank you" text.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='green_text_margin']")));
        WebElement confirmed_text = driver.findElement(By.xpath("//span[@class='green_text_margin']"));
        System.out.println("confirmed_text.getText() = " + confirmed_text.getText());
        String confirmed = confirmed_text.getText().toString();
        if (confirmed.equalsIgnoreCase("your order is confirmed. Thank you!"))
            System.out.println("Order processed succesfully.");
        else System.out.println("Error");


        BekleKapat();

    }

}
