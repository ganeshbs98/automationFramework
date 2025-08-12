package Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RedbusAssignment {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public static void main(String[] args) throws InterruptedException {
        //Chrome setUp
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);

        driver.get("https://www.redbus.in/");
        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
        By FromInput = By.xpath("//div[contains(@class,'labelCityWrapper___')]");
        wait.until(ExpectedConditions.elementToBeClickable(FromInput)).click();

        setLocationData("Mumbai");
        setLocationData("Pune");
        //Click on Search Button
        By searchLocator = By.xpath("//button[text()='Search buses']");
        wait.until(ExpectedConditions.elementToBeClickable(searchLocator)).click();

        By TotalBuses = By.xpath("//span[contains(@class,'subtitle___')]");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(TotalBuses, "buses"));

        By filterPrimoLoc = By.xpath("//div[contains(@aria-label,'Primo ')]");
        By filterHighRateLoc = By.xpath("//div[contains(@aria-label,'High Rated Buses ')]");
        WebElement primoele = wait.until(ExpectedConditions.elementToBeClickable(filterPrimoLoc));
        primoele.click();
        Thread.sleep(2000);
        WebElement highRateEle = wait.until(ExpectedConditions.elementToBeClickable(filterHighRateLoc));
        highRateEle.click();
        WebElement subTitle = null;
        if (wait.until(ExpectedConditions.textToBePresentInElementLocated(TotalBuses, "buses"))) {
            subTitle = wait.until(ExpectedConditions.elementToBeClickable(TotalBuses));
            System.out.println(subTitle.getText());
        }

        By BusesWrapper = By.xpath("//li[contains(@class,'tupleWrapper__')]");
        By BusName = By.xpath(".//div[contains(@class,'travelsName')]");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        while (true) {
            List<WebElement> rowList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(BusesWrapper));
            List<WebElement> endList = driver.findElements(By.xpath("//span[contains(text(),'End of list')]"));
            if (!endList.isEmpty()) {
                break;
            }
            js.executeScript("arguments[0].scrollIntoView({behavior:'smooth'});", rowList.get(rowList.size() - 3));

        }
        List<WebElement> rowList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(BusesWrapper));
        for (WebElement row : rowList) {
            System.out.println(row.findElement(BusName).getText());
            ;
        }
        System.out.println("Total Number of buses loaded with filter primo and High Rated is " + rowList.size());


    }

    public static void setLocationData(String locationData) {
        try {
            Thread.sleep(2000);
            WebElement activeEle = driver.switchTo().activeElement();
            activeEle.sendKeys(locationData);
            By searchCategory = By.xpath("//div[contains(@class,'searchCategory___')]");
            By suggestionListLocator = By.xpath(".//div[contains(@class,'listHeader___')]");
            List<WebElement> searchListElement = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(searchCategory, 1));
            System.out.println(searchListElement.size());
            WebElement searchLocationele = searchListElement.get(0);
            List<WebElement> LocationSuggestionList = searchLocationele.findElements(suggestionListLocator);
            for (WebElement location : LocationSuggestionList) {
                if (location.getText().trim().equalsIgnoreCase(locationData)) {
                    wait.until(ExpectedConditions.elementToBeClickable(location)).click();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void enterTheDesitnations(By Locator, String location) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(Locator)).click();
        Thread.sleep(1500);

    }
}
