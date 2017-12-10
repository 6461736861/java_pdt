package pdt.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import pdt.addressbook.models.ContactAddress;
import pdt.addressbook.models.ContactNameSurname;

/**
 * Created by rb on 12/10/17.
 */
public class ContactCreationHelper {
    private FirefoxDriver wd;

    public ContactCreationHelper(FirefoxDriver wd) {
        this.wd = wd;
    }
    public void initCreatContact() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void fillCOntactBirthDate() {
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

    public void fillContactPersonalData(ContactAddress contactAddress) {
        wd.findElement(By.name("company")).click();
        wd.findElement(By.name("company")).sendKeys(contactAddress.getCompanyName());
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).sendKeys(contactAddress.getContactStreet());
        wd.findElement(By.name("home")).click();
        wd.findElement(By.name("home")).sendKeys(contactAddress.getContactPhone());
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).sendKeys(contactAddress.getContactEmail());
    }

    public void fillContactNameSurnameSalutation(ContactNameSurname contactNameSurname) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).sendKeys(contactNameSurname.getContactName());
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).sendKeys(contactNameSurname.getContactSurname());
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).sendKeys(contactNameSurname.getContactNickname());
        wd.findElement(By.name("title")).click();
        wd.findElement(By.name("title")).sendKeys(contactNameSurname.getSalutation());
    }
}
