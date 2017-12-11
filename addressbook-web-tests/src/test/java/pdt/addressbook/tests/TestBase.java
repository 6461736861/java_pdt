package pdt.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pdt.addressbook.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;


/**
 * Created by rb on 12/8/17.
 */
public class TestBase {

    protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeMethod
    public void setUP() {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

}
