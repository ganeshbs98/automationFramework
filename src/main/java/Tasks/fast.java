package Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class fast {

    private WebDriver driver;
    private WebDriverWait wait;

    @Test
    public void fast() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://fast.com");
        By spinner = By.id("speed-progress-indicator");
        By internetSpeed = By.id("speed-value");
        By speedUnit = By.id("speed-units");
        String classname = null;
        while (true) {
            WebElement speedvalue = wait.until(ExpectedConditions.visibilityOfElementLocated(internetSpeed));
            WebElement speedunit = wait.until(ExpectedConditions.visibilityOfElementLocated(speedUnit));
            System.out.println(speedvalue.getText() + " " + speedunit.getText());
            classname = speedvalue.getAttribute("class");
            if (classname.contains("succeeded")) {
                break;
            }

        }
        System.out.println("-------------------Final Speed-------------------");
        WebElement speedvalue = wait.until(ExpectedConditions.visibilityOfElementLocated(internetSpeed));
        WebElement speedunit = wait.until(ExpectedConditions.visibilityOfElementLocated(speedUnit));
        System.out.println(speedvalue.getText() + " " + speedunit.getText());

        driver.quit();

    }
}
