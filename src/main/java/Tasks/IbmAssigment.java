package Tasks;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class IbmAssigment {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @Test
    public static void IbmAssignment() {
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        driver=new ChromeDriver(options);
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://jatin99.github.io/ShadowDomAssignment/");
        By HybridLocator= By.cssSelector("input#email");
        wait.until(ExpectedConditions.elementToBeClickable(HybridLocator)).sendKeys("Ganesh.bs@foodhub.com");
        By headerText=By.cssSelector(".header");
        String Header=wait.until(ExpectedConditions.visibilityOfElementLocated(headerText)).getText();
        System.out.println(Header);
        By headerInput=By.cssSelector("input[name='username']");
        wait.until(ExpectedConditions.elementToBeClickable(headerInput)).sendKeys("007");
        By submitbtnLocator=By.cssSelector("button[type='submit']");
        wait.until(ExpectedConditions.elementToBeClickable(submitbtnLocator)).click();
        By headerTextt=By.cssSelector("div.main");
        String text=wait.until(ExpectedConditions.elementToBeClickable(headerTextt)).getText();
        System.out.println(text);
        By ItemLocator=By.cssSelector("ul > li");
       String item= wait.until(ExpectedConditions.elementToBeClickable(ItemLocator)).getText();
        System.out.println(item);
        List<WebElement> items=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ItemLocator));
        System.out.println(items.size());
        By itemLocator2=By.cssSelector("ul > li:nth-child(3)");
        String item3= wait.until(ExpectedConditions.elementToBeClickable(itemLocator2)).getText();
        System.out.println(item3);
        WebElement ele=driver.findElement(itemLocator2);
        By parentShadow=By.xpath("//my-component");
        WebElement shele=driver.findElement(parentShadow);
        SearchContext shadowContext=shele.getShadowRoot();
        By shadowLoactor=By.cssSelector("div.header");
        String shatext=shadowContext.findElement(shadowLoactor).getText();
        System.out.println(shatext);


        driver.quit();
    }
}
