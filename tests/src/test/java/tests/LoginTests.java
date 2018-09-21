package tests;

import config.Config;
import org.junit.Assert;
import org.junit.Test;
import pages.Home;

import static config.WebDriverSingleton.getInstance;

public class LoginTests extends Config {

    @Test
    public void userShouldLogInWithValidData(){

        new Home()
                .openSignInPage()
                .logInWithValidData();

        Assert.assertTrue(getInstance().getTitle().equals("My account - My Store"));

    }


}
