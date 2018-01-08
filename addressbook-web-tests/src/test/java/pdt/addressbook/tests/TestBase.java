package pdt.addressbook.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pdt.addressbook.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;


/**
 * Created by rb on 12/8/17.
 */
public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeSuite
    public void setUP() {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

}
