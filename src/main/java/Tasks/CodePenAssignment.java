package Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodePenAssignment {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @Test
    public void codePenTest() {
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        Map<String,Object> prefs=new HashMap<String,Object>();
        File DownloadFilepath=new File(System.getProperty("user.dir")+File.separator+"Downloads");
        prefs.put("download.default_directory", DownloadFilepath);
        prefs.put("download.prompt_for_download","false");
        options.setExperimentalOption("prefs",prefs);
        if(!DownloadFilepath.exists()){
            DownloadFilepath.mkdir();
        }
        driver=new ChromeDriver(options);
        driver.get("https://codepen.io/rolandixor/pen/mdwZReq");
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        By InputBox= By.cssSelector("div.CodeMirror");
        List<WebElement> inputBoxList=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(InputBox));
        System.out.println(inputBoxList.size());

        // Implementation for CodePen assignment test
        driver.quit();
    }

}
