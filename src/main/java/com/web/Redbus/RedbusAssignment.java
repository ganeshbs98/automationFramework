package com.web.Redbus;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RedbusAssignment {
    public static WebDriverWait wait;

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.redbus.in/");
//        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        By srcDest = By.xpath("//div[contains(@class,'srcDestWrapper') and @role='button']");
        By searchSuggesstionlocator = By.xpath("//div[contains(@class,'searchSuggestionWrapper')]");
        WebElement input = driver.findElement(srcDest);
        input.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchSuggesstionlocator));
        selectLocation(driver, "mumbai");
        selectLocation(driver, "Pune");
//
        By SearchButtonLoc = By.xpath("//button[text()='Search buses']");
        wait.until(ExpectedConditions.elementToBeClickable(SearchButtonLoc)).click();
        Thread.sleep(3000);
//        if(driver.findElement(By.xpath("//button[text()='Proceed']")).isDisplayed()){
//            driver.findElement(By.xpath("//button[text()='Proceed']")).click();
//        }
        By filterWrapper=By.xpath("//div[contains(@class,'mainContainer')]//div[contains(@class,'label')]");
        selectFilter(filterWrapper,"Primo Bus");
        selectFilter(filterWrapper,"AC");
        By filteredTitleLocator=By.xpath("//div[contains(@class,'busesFoundText__')]");

        String filterListText=wait.until(ExpectedConditions.visibilityOfElementLocated(filteredTitleLocator)).getText();
        System.out.println(filterListText);
        By subTitleLocator=By.xpath("//span[contains(@class,'subtitle')]");
        String subtitletext=wait.until(ExpectedConditions.visibilityOfElementLocated(subTitleLocator)).getText();

        System.out.println(subtitletext);


//           List<WebElement>listOfBuses=driver.findElements(By.xpath("//ul[contains(@class,'srpList__ind')]/li"));
//           for(WebElement ele:listOfBuses){
//               System.out.println(ele.getText());
//           }
//       };
//        By
        By busNameLocator=By.xpath("//div[contains(@class,'travelsName_')]");
        List<WebElement>busNameList=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(busNameLocator));
        for(WebElement bus:busNameList){
            String busName=bus.getText().trim();
            System.out.println(busName);

        }
        //How to scroll in selenium
        JavascriptExecutor jrs = (JavascriptExecutor) driver;
        jrs.executeScript("arguments[0].scrollIntoView({behaviour:'smooth'});",busNameList.get(busNameList.size()-3));
        Thread.sleep(5000);
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy())

    }

    public static void selectLocation(WebDriver driver, String Location) throws InterruptedException {
        WebElement SearchSuggestionElement = driver.switchTo().activeElement();
        SearchSuggestionElement.sendKeys(Location);
        Thread.sleep(2000);
        By SuggestionListlocator = By.xpath("//div[contains(@class,'searchCategory')]");
        List<WebElement> suggestionListElements = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(SuggestionListlocator, 1));
        System.out.println(suggestionListElements.size());
        WebElement locationElement = suggestionListElements.get(0);
        By locatorELement = By.xpath(".//div[contains(@class,'listHeader___')]");
        List<WebElement> fromText = locationElement.findElements(locatorELement);
        System.out.println(fromText.size());

        for (WebElement ele : fromText) {
            String text = ele.getText().trim();
            System.out.println(text);
            if (text.equalsIgnoreCase(Location)) {
                ele.click();
                break;
            }
        }
    }
    public static void selectFilter(By locator,String filterText){
        List<WebElement>filterElements=wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator,2));
        for(WebElement ele:filterElements){
            String text= ele.getText();
            System.out.println(text);
            if(text.contains(filterText)){
                ele.click();
                break;
            }
        }
    }

    public static void clickAction(By locator) {
        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(locator));
        ele.click();

    }

    public static void enterText(By locator, String text_To_Enter) {
        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(locator));
        ele.sendKeys(text_To_Enter);
    }
}
