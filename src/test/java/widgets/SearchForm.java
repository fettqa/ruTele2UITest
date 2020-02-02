package widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SearchForm {
    private final WebDriver driver;

    public SearchForm(final WebDriver driver) {
        this.driver = driver;
    }

    public SearchForm enterRequest(final String request) {

        driver.findElement(By.xpath("//input[@id=\"search-text\"]")).sendKeys(request);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        return this;
    }

    public TariffMyConversationPage goToTariffMyConversationPage() {

        driver.findElement(By.xpath("//a[@href='/tariff/my-conversation']")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        return new TariffMyConversationPage(driver);

    }
}
