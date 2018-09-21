import config.Config;
import config.FormData;
import org.junit.Assert;
import org.junit.Test;

import pages.Home;
import pages.SignUp;

import static config.WebDriverSingleton.getInstance;

public class LaunchTest extends Config {


    @Test
    public void launchTest(){

        new Home()
                .openSignInPage()
                .submitRegistrationEmail("tasdasfgdsafs@gmail.com");

        Assert.assertEquals("Login - My Store", getInstance().getTitle());

    }

    @Test
    public void testRegistrationWithValidData(){

        new Home()
                .openSignInPage()
                .submitRegistrationEmail("tasdasfgdsafs@gmail.com")
                .submitValidForm(new FormData("random", "random", "random",
                        0, 0 , 0, "random", "random",
                        "random", "random", "random", "random",
                        "random", "random", "random", "random"));


    }

}
