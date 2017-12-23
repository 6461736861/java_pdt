package pdt.addressbook.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pdt.addressbook.appmanager.*;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;


/**
 * Created by rb on 12/8/17.
 */
public class TestBase {
    protected WebDriver wd;
    protected NavigationHelper navigationHelper;
    protected GroupHelper groupHelper;
    protected SessionHelper sessionHelper;
    protected ContactHelper contactHelper;
    protected String browser;

    @BeforeMethod
    public void setUP() {
        System.setProperty("webdriver.gecko.driver", "/Users/rb/java_pdt/addressbook-web-tests/geckodriver");
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        contactHelper = new ContactHelper(wd);
        // wd.get("http://localhost:81/addressbook/");
        wd.get("http://localhost/addressbook/");
        sessionHelper.login("admin", "secret");
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }


}
