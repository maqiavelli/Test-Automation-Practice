package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends BasePage {

    public Home(){
        super();
    }

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    public WebElement signInButton;

    public SignIn openSignInPage(){
        signInButton.click();
        return new SignIn();
    }


}
