package config;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import static config.WebDriverSingleton.getInstance;
import static config.WebDriverSingleton.quit;

public class Config {

    private WebDriver driver;

    @Before
    public void setUp() {
        String baseUrl = "http://automationpractice.com/index.php";

        driver = getInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @After
    public void tearDown(){

        takeScreenShot();
        quit();
    }


    public static void waitForVisibilityOfElement(WebElement element){

        WebDriverWait wait = new WebDriverWait(getInstance(), 10);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    private static void takeScreenShot(){

        File screenshot = ((TakesScreenshot)getInstance()).getScreenshotAs(OutputType.FILE);

        try{
            FileUtils.copyFile(screenshot,new File("D:\\screens\\" + LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE)
                    + "\\" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmss")) + ".jpg"), true );
        } catch(IOException ex){
            System.err.println("IOException caught" + ex.getMessage());
        }

    }
}
