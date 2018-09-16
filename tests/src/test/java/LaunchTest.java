import config.Config;
import org.junit.Test;

import pages.Home;

public class LaunchTest extends Config {


    @Test
    public void launchTest(){

        new Home()
                .openSignInPage();

    }




}
