import config.Config;
import org.junit.Assert;
import org.junit.Test;

import pages.BasePage;
import pages.Home;

import static config.WebDriverSingleton.getInstance;

public class LaunchTest extends Config {


    @Test
    public void launchTest(){

        new Home()
                .openSignInPage()
                .submitEmail("tasdasfgdsafs@gmail.com");

        Assert.assertEquals("Login - My Store", getInstance().getTitle());

    }

}
