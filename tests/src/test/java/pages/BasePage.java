package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import static config.Config.waitForVisibilityOfElement;
import static config.WebDriverSingleton.getInstance;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(getInstance(), this);
        waitForVisibilityOfElement(columns);
    }

    @FindBy(id = "columns")
    public WebElement columns;


}
