package pdt.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import pdt.addressbook.models.ContactAddress;
import pdt.addressbook.models.ContactNameSurname;

/**
 * Created by rb on 12/10/17.
 */
public class ContactHelper extends BaseHelper {

    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }
    public void initCreatContact() {
        click(By.linkText("add new"));
    }

    public void fillCOntactBirthDate() {
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[17]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[1]//option[17]"));
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[3]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select[2]//option[3]"));
        }
        click(By.name("byear"));
        wd.findElement(By.name("byear")).clear();
        wd.findElement(By.name("byear")).sendKeys("1990");
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactPersonalData(ContactAddress contactAddress) {
        click(By.name("company"));
        wd.findElement(By.name("company")).sendKeys(contactAddress.getCompanyName());
        click(By.name("address"));
        wd.findElement(By.name("address")).sendKeys(contactAddress.getContactStreet());
        click(By.name("home"));
        wd.findElement(By.name("home")).sendKeys(contactAddress.getContactPhone());
        click(By.name("email"));
        wd.findElement(By.name("email")).sendKeys(contactAddress.getContactEmail());
    }

    public void fillContactNameSurnameSalutation(ContactNameSurname contactNameSurname) {
        click(By.name("firstname"));
        wd.findElement(By.name("firstname")).sendKeys(contactNameSurname.getContactName());
        click(By.name("lastname"));
        wd.findElement(By.name("lastname")).sendKeys(contactNameSurname.getContactSurname());
        click(By.name("nickname"));
        wd.findElement(By.name("nickname")).sendKeys(contactNameSurname.getContactNickname());
        click(By.name("title"));
        wd.findElement(By.name("title")).sendKeys(contactNameSurname.getSalutation());
    }
}
