package tests;

import config.Config;
import config.FormData;
import org.junit.Assert;
import org.junit.Test;

import pages.Home;
import pages.SignUp;

import static config.WebDriverSingleton.getInstance;

public class RegistrationTests extends Config {


    @Test
    public void smokeTest(){

        new Home()
                .openSignInPage()
                .submitRegistrationEmail("tasdasfgdsafs@gmail.com");

        Assert.assertTrue(getInstance().getTitle().equals("Login - My Store"));

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

    @Test
    public void testRegistrationWithInvalidData(){

        new Home()
                .openSignInPage()
                .submitRegistrationEmail("tasdasfgdsafs@gmail.com")
                .submitValidForm(new FormData("", "random", "random",
                        0, 0 , 0, "random", "random",
                        "random", "random", "random", "random",
                        "random", "random", "random", "random"));
        Assert.assertTrue(getInstance().getTitle().equals("Login - My Store"));
    }

}
