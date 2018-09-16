package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static config.WebDriverSingleton.getInstance;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(getInstance(), this);
        WebDriverWait wait = new WebDriverWait(getInstance(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#columns")));
    }

}
