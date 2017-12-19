package pdt.addressbook.appmanager;

import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.SkipException;
import pdt.addressbook.models.ContactAddress;
import pdt.addressbook.models.ContactNameSurname;

import java.util.concurrent.TimeUnit;

/**
 * Created by rb on 12/10/17.
 */
public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver wd) {
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
        typeFieldValue(By.name("company"), contactAddress.getCompanyName());
        click(By.name("address"));
        typeFieldValue(By.name("address"), contactAddress.getContactStreet());
        click(By.name("home"));
        typeFieldValue(By.name("home"), contactAddress.getContactPhone());
        click(By.name("email"));
        typeFieldValue(By.name("email"), contactAddress.getContactEmail());
    }

    public void fillContactNameSurnameSalutation(ContactNameSurname contactNameSurname) {
        click(By.name("firstname"));
        typeFieldValue(By.name("firstname"), contactNameSurname.getContactName());
        click(By.name("lastname"));
        typeFieldValue(By.name("lastname"), contactNameSurname.getContactSurname());
        click(By.name("nickname"));
        typeFieldValue(By.name("nickname"), contactNameSurname.getContactNickname());
        click(By.name("title"));
        typeFieldValue(By.name("title"), contactNameSurname.getSalutation());
    }

    public void selectContact() {
        if (wd.findElements(By.name("selected[]")).size() != 0) {
            click(By.name("selected[]"));
        } else {
            this.initCreatContact();
            this.fillContactPersonalData(new ContactAddress("dsfdsffsd", "sdffdsfdsf 534", "234234234243", "werwerwre@sgfsgf."));
            this.saveContact();
            click(By.name("selected[]"));
        }
    }

    public void modifyContact() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));

    }

    public void saveContactChanges() {
        click(By.name("update"));
    }

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void saveContact() {
        click(By.name("submit"));
    }
}
