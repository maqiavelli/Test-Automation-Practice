package config;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        quit();
    }

    public static void waitForVisibilityOfElement(WebElement element){

        WebDriverWait wait = new WebDriverWait(getInstance(), 10);
        wait.until(ExpectedConditions.visibilityOf(element));

    }
}
