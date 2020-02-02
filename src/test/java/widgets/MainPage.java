package widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public SearchForm clickOnSearchLink() {
        driver.findElement(By.xpath("//div[@class=\"header-new\"]/descendant::a[@class=\"search\"]")).click();
        return new SearchForm(driver);
    }

}
