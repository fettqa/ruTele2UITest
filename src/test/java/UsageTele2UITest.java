import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import widgets.MainPage;
import widgets.SearchForm;
import widgets.TariffMyConversationPage;

public class UsageTele2UITest {

    private WebDriver driver;

    @BeforeMethod

    public void setUp() {
        String projectLocation = System.getProperty(Configurations.CHROME_WEBDRIVER_LOCATION);
        System.setProperty("webdriver.chrome.driver", projectLocation + "/lib/chromedriver/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary(Configurations.CHROME_BROWSER_BINARY_LOCATION);
        this.driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @Test

    public void tele2UITest() {
        driver.get(Configurations.BASE_URL);
        MainPage mainPage = new MainPage(this.driver);
        SearchForm searchForm = mainPage.clickOnSearchLink();
        TariffMyConversationPage tariffMyConversationPage = searchForm
                .enterRequest("Мой")
                .goToTariffMyConversationPage();
        Assert.assertEquals(Configurations.EXPECTED_PRICE_RESULT,tariffMyConversationPage.getPrice());
        Assert.assertEquals(driver.getCurrentUrl(), (Configurations.BASE_URL + Configurations.EXPECTED_ADDRESS_RESULT));
    }

    @AfterMethod

    public void closeBrowser() {
        driver.quit();
    }
}
