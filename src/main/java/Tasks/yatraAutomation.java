package Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.Map;

public class yatraAutomation {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public static void main(String[] args) throws InterruptedException {
        // Initialize Chrome with options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);

        // Navigate to Yatra.com
        driver.get("https://www.yatra.com/");

        // Create explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.switchTo().frame("");
        By offerbanner=By.xpath("//a[contains(@href,'offer')]");
        By offerbannerClose=By.xpath("//button[@name=\"close\"]");
        boolean offrstatus=isElementVisible(offerbanner, driver, 10);
        if (offrstatus) {
            wait.until(ExpectedConditions.elementToBeClickable(offerbannerClose)).click();
        }

        By loginPopup = By.xpath("(//div[contains(@class,'style_popup__a7PrI')]/section)[2]");
        By popupCloseButton = By.xpath(".//img[@alt='cross']");
        boolean loginstatus=isElementVisible(loginPopup,driver,10);
        if(loginstatus){
            WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPopup));
            WebElement closeButton = popup.findElement(popupCloseButton);
            closeButton.click();
        }
        // Click on the departure date input box
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Departure Date inputbox']"))).click();

        // Calendar month container
        By julMonthContainer = By.xpath("//div[@class='react-datepicker__month-container']");

        // Get both current and next month calendars
        List<WebElement> CalenderMonths = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(julMonthContainer));
        System.out.println(CalenderMonths.size());

        // Get the first (current) month calendar
        WebElement CurrentMonthCalender = CalenderMonths.get(0);
        Thread.sleep(3000); // Allow calendar to fully render

        // Locate all price elements in the current month
        By priceslocator = By.xpath(".//span[contains(@class,'custom-day-content')]");
        List<WebElement> pricesList = CurrentMonthCalender.findElements(priceslocator);

        // Get the lowest price and corresponding date element from the current month
        Map.Entry<Integer, WebElement> data = getLowestPriceInMonth(pricesList);
        int LowestPriceInCurentMonth = data.getKey();
        WebElement dateEle = data.getValue();
        String date = dateEle.findElement(By.xpath(".//../..")).getAttribute("aria-label");

        // Move to the next month calendar
        WebElement NextMonthCalender = CalenderMonths.get(1);
        Thread.sleep(3000); // Wait for next month's calendar to be visible
        pricesList = NextMonthCalender.findElements(priceslocator);

        // Get the lowest price and corresponding date element from the next month
        data = getLowestPriceInMonth(pricesList);
        int LowestPriceInNextMonth = data.getKey();
        WebElement dateEl = data.getValue();
        String dateInNext_month = dateEl.findElement(By.xpath(".//../..")).getAttribute("aria-label");

        // Compare and print which month has the lowest price
        if (LowestPriceInCurentMonth < LowestPriceInNextMonth) {
            System.out.println("👉 Current month has the lowest price: ₹" + LowestPriceInCurentMonth + " on " + date);
        } else if (LowestPriceInNextMonth < LowestPriceInCurentMonth) {
            System.out.println("👉 Next month has the lowest price: ₹" + LowestPriceInNextMonth + " on " + dateInNext_month);
        } else {
            System.out.println("👉 Both months have the same lowest price: ₹" + LowestPriceInCurentMonth + " on either " + date + " or " + dateInNext_month);
        }

        // Close the browser
        driver.quit();
    }

    /**
     * Finds the lowest price from the given list of price elements and returns both
     * the price and the corresponding element.
     *
     * @param pricesList List of WebElements representing prices
     * @return Map.Entry with key as lowest price and value as the corresponding WebElement
     */
    private static Map.Entry<Integer, WebElement> getLowestPriceInMonth(List<WebElement> pricesList) {
        int lowestPrice = Integer.MAX_VALUE;
        WebElement lowestPriceElement = null;

        for (WebElement price : pricesList) {
            if (price.getText().length() > 0) {
                // Clean up and parse the price text
                String priceStr = price.getText().replaceAll("₹", "").replace(",", "").trim();
                int priceInt = Integer.parseInt(priceStr);

                // Update lowest price if a smaller one is found
                if (priceInt < lowestPrice) {
                    lowestPrice = priceInt;
                    lowestPriceElement = price;
                }
            }
        }

        // Return the price and corresponding element
        return new SimpleEntry<>(lowestPrice, lowestPriceElement);
    }
    public static boolean isElementVisible(By locator, WebDriver driver, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
