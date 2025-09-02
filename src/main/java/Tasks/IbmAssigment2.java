package Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class IbmAssigment2 {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @Test
    public static void IbmAssignment() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get("https://www.ibm.com/in-en");

        By HybridShadowParentComponent = By.xpath("//c4d-megamenu-top-nav-menu[@menu-label='Hybrid Cloud']");
        WebElement HybridShadowEle = wait.until(ExpectedConditions.elementToBeClickable(HybridShadowParentComponent));
        SearchContext HybridshadowContext = HybridShadowEle.getShadowRoot();
        By shadowLoactor = By.cssSelector("a");
        HybridshadowContext.findElement(shadowLoactor).click();

        By ITInfraLocator = By.xpath("//c4d-megamenu-category-heading[@title=\"IT infrastructure\"]");
        wait.until(ExpectedConditions.elementToBeClickable(ITInfraLocator)).click();


        driver.quit();
    }
}
