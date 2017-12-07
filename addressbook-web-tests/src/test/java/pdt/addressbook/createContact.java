package pdt.addressbook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class createContact {
    FirefoxDriver wd;

    @BeforeMethod
    public void setUP() {
        System.setProperty("webdriver.gecko.driver", "/Users/rb/java_pdt/addressbook-web-tests/geckodriver");
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        login("admin", "secret");
    }

    public void login(String username, String password) {
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    @Test

    public void createContactTest() {
        initCreatContact();
        fillContactNameSurnameSalutation(new ContactNameSurname("Dasha", "Test", "nickname", "MS"));
        fillContactPersonalData(new ContactAddress("someCompany", "Grafenberger Allee 222", "1111111", "dasha@gmail.com"));
        fillCOntactBirthDate();
        wd.quit();
    }

    private void fillCOntactBirthDate() {
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[17]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[17]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[3]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[3]")).click();
        }
        wd.findElement(By.name("byear")).click();
        wd.findElement(By.name("byear")).clear();
        wd.findElement(By.name("byear")).sendKeys("1990");
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    private void fillContactPersonalData(ContactAddress contactAddress) {
        wd.findElement(By.name("company")).click();
        // wd.findElement(By.name("company")).clear();
        wd.findElement(By.name("company")).sendKeys(contactAddress.getCompanyName());
        wd.findElement(By.name("address")).click();
        //   wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(contactAddress.getContactStreet());
        wd.findElement(By.name("home")).click();
        //  wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys(contactAddress.getContactPhone());
        wd.findElement(By.name("email")).click();
        // wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(contactAddress.getContactEmail());
    }

    private void fillContactNameSurnameSalutation(ContactNameSurname contactNameSurname) {
        wd.findElement(By.name("firstname")).click();
        // wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(contactNameSurname.getContactName());
        wd.findElement(By.name("lastname")).click();
        // wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(contactNameSurname.getContactSurname());
        wd.findElement(By.name("nickname")).click();
        // wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys(contactNameSurname.getContactNickname());
        wd.findElement(By.name("title")).click();
        // wd.findElement(By.name("title")).clear();
        wd.findElement(By.name("title")).sendKeys(contactNameSurname.getSalutation());
    }

    private void initCreatContact() {
        wd.findElement(By.linkText("add new")).click();
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
