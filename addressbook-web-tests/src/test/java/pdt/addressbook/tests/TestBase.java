package pdt.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pdt.addressbook.appmanager.ApplicationManager;

/**
 * Created by rb on 12/8/17.
 */
public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUP() {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

}
