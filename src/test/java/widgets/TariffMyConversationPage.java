package widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class TariffMyConversationPage {

    private final WebDriver driver;

    public TariffMyConversationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPrice() {
        driver.manage().timeouts().setScriptTimeout(5,TimeUnit.SECONDS);
        return driver.findElement(By.cssSelector("div.tariff-card-new__main-block * span.price > span")).getText();
    }
}
