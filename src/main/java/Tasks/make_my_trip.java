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
import java.util.List;
import java.util.Locale;

public class make_my_trip {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);

        driver.get("https://www.makemytrip.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        By modalCloseButton = By.xpath("//span[@data-cy='closeModal']");
        By travelCardCLose = By.xpath("//span[@data-cy='travel-card-close']");

        click(modalCloseButton);
        click(travelCardCLose);
        // FromLocation
        By fromInput = By.id("fromCity");
        By toCityInput = By.id("toCity");
        click(fromInput);
        By suggestionsLocator = By.xpath("(//li[contains(@id,'react-autowhatever')])");
        selectLocation(suggestionsLocator,"Mumbai");
        //toLocation
        click(toCityInput);
        selectLocation(suggestionsLocator,"Hyderabad");

        //Selcting the Date
        LocalDate tagretDate = LocalDate.now();
        tagretDate = tagretDate.plusDays(5);
        String month = tagretDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        int targetDay = tagretDate.getDayOfMonth();
        int year = tagretDate.getYear();
        By datePickerLocator = By.xpath("//div[text()='" + month + " " + year + "']/ancestor::div[@class=\"DayPicker-Month\"]");
        By datelocatore = By.xpath(".//p[text()='" + targetDay + "']/ancestor::div[contains(@class,'DayPicker-Day')]");
        WebElement calender = wait.until(ExpectedConditions.visibilityOfElementLocated(datePickerLocator));
        calender.findElement(datelocatore).click();

    }

    public static boolean click(By locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
            return true;
        } catch (Exception e) {
            System.out.println("Element not clickable: " + locator);
            return false;
        }
    }
    public static void selectLocation(By suglocator,String locationData) throws InterruptedException {
        driver.switchTo().activeElement().sendKeys(locationData);
        Thread.sleep(2000);
        By nameOfcitylocator = By.xpath(".//p[1]");
        List<WebElement> suggestions = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(suglocator, 2));
        System.out.println(suggestions.size());
        for (WebElement suggestion : suggestions) {
            WebElement ele = suggestion.findElement(nameOfcitylocator);
            if (ele.getText().trim().contains(locationData)) {
                wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
                break;

            }
        }
    }

}
