package pages;

import com.sun.org.glassfish.external.probe.provider.annotations.ProbeListener;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignIn extends BasePage {

    public SignIn(){super();}

    @FindBy(id = "email_create")
    WebElement emailCreate;

    @FindBy(id = "SubmitCreate")
    WebElement submitCreate;

    @FindBy(id = "email")
    WebElement emailLogin;

    @FindBy(id = "passwd")
    WebElement passwordLogin;

    @FindBy(id = "SubmitLogin")
    WebElement submitLoginButton;



    public SignedIn logInWithValidData(){

        return submitSignInForm("testing123454321testing@gmail.com", "qwert12345");

    }



    public SignUp submitRegistrationEmail(String email){
        emailCreate.sendKeys(email);
        submitCreate.click();
        return new SignUp();
    }

    public SignedIn submitSignInForm(String email, String password){

        this.emailLogin.sendKeys(email);
        this.passwordLogin.sendKeys(password);
        this.submitLoginButton.click();
        return new SignedIn();

    }


}
