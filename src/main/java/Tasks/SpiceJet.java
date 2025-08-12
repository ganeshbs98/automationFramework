package Tasks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class SpiceJet {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public static void main(String[] args) {
        //chrome Setup
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);

        //launch the driver
        driver.get("https://www.spicejet.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        By FromLocator = By.xpath("//div[text()='From']/following-sibling::div/input");
        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(FromLocator));
        ele.sendKeys("Beng");

        By ToLocator = By.xpath("//div[text()='To']/following-sibling::div/input");
        WebElement toEle = wait.until(ExpectedConditions.visibilityOfElementLocated(ToLocator));
        toEle.sendKeys("Mum");

        By calenderLocator = By.xpath("//div[@data-testid='undefined-calendar-picker']");
        WebElement calenderEle = wait.until(ExpectedConditions.visibilityOfElementLocated(calenderLocator));

        By svgElementLocator = By.xpath(".//*[local-name()='svg' and @data-testid='svg-img']");
        calenderEle.findElement(svgElementLocator).click();

        LocalDate localDate = LocalDate.now();
        localDate = localDate.plusMonths(3);
        String Month = localDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        int year = localDate.getYear();
        int day = localDate.getDayOfMonth();

        By MonthLocator = By.xpath("//div[@data-testid='undefined-month-" + Month + "-" + year + "']");
        By dateLocator = By.xpath(".//div[@data-testid='undefined-calendar-day-" + day + "']");

        WebElement monthEle = wait.until(ExpectedConditions.visibilityOfElementLocated(MonthLocator));
        monthEle.findElement(dateLocator).click();
        sleepFor(4);

        //quitting the driver
        driver.quit();


    }

    public static void sleepFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}



