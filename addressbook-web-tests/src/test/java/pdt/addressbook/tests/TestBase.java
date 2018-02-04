package pdt.addressbook.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pdt.addressbook.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;

import java.io.IOException;


/**
 * Created by rb on 12/8/17.
 */
public class TestBase {

    protected static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite
    public void setUP() throws IOException {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

}
