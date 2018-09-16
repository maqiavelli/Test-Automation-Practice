package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignIn extends BasePage {

    public SignIn(){super();}

    @FindBy(id = "email_create")
    public WebElement emailCreate;

    @FindBy(id = "SubmitCreate")
    public WebElement submitCreate;

    @FindBy(id = "email")
    public WebElement emailLogin;

    @FindBy(id = "passwd")
    public WebElement passwordLogin;



    public SignUp submitEmail(String email){
        emailCreate.sendKeys(email);
        submitCreate.click();
        return new SignUp();
    }


}
