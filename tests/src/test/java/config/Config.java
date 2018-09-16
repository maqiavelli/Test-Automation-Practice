package config;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class Config {

    private WebDriver driver;

    @Before
    public void setUp() {
        String startUrl = "";

        driver = WebDriverSingleton.getInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(startUrl);
    }

    @After
    public void tearDown{
        WebDriverSingleton.quit();
    }
}
