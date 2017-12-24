package pdt.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pdt.addressbook.models.ContactData;

/**
 * Created by rb on 12/10/17.
 */
public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void initCreateContact() {
        click(By.linkText("add new"));
    }

    public void fillContactBirthDate() {
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

    public void fillContact(ContactData contact) {
        typeFieldValue(By.name("firstname"), contact.name);
        typeFieldValue(By.name("lastname"), contact.surname);
        typeFieldValue(By.name("nickname"), contact.nickname);
        typeFieldValue(By.name("title"), contact.title);
        typeFieldValue(By.name("company"), contact.companyName);
        typeFieldValue(By.name("email"), contact.email);
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void modifyContact() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));

    }

    public void saveContactChanges() {
        click(By.name("update"));
    }

    public void deleteContact() {
       // new WebDriverWait(wd, 5).until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//td[.='DeleteCustomer']"), "DeleteCustomer"));
        click(By.name("selected[]"));
        click(By.xpath("//input[@value='Delete']"));
    }

    public void saveContact() {
        click(By.name("submit"));
    }

    public void createContact(ContactData contact) {
        this.initCreateContact();
        this.fillContact(contact);
        this.saveContact();

    }

    public boolean isAnyContactExists() {
      return !wd.findElement(By.id("search_count")).getText().contains("0");
    }


}
