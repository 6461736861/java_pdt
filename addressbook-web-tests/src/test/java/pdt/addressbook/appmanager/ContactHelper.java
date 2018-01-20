package pdt.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pdt.addressbook.models.ContactData;
import pdt.addressbook.models.Contacts;
import pdt.addressbook.models.GroupData;
import pdt.addressbook.models.Groups;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public void fill(ContactData contact) {
        typeFieldValue(By.name("firstname"), contact.name);
        typeFieldValue(By.name("lastname"), contact.surname);
        typeFieldValue(By.name("nickname"), contact.nickname);
        typeFieldValue(By.name("title"), contact.title);
        typeFieldValue(By.name("company"), contact.companyName);
        typeFieldValue(By.name("email"), contact.email);
    }

    public void modifyContactById(int id) {
        // click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
        wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%d']", id))).click();
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void modify(ContactData contact) {
        selectContactById(contact.getId());
        modifyContactById(contact.getId());
        fill(contact);
        saveChanges();
        contactCache = null;
    }


    public void saveChanges() {
        click(By.name("update"));
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        click(By.xpath("//input[@value='Delete']"));
        submit();
        contactCache = null;
    }

    public void save() {
        click(By.name("submit"));
        contactCache = null;
    }

    public void create(ContactData contact) {
        initCreateContact();
        fill(contact);
        save();
        contactCache = null;

    }

    public boolean isAnyContactExists() {
        return !wd.findElement(By.id("search_count")).getText().contains("0");
    }

    private Contacts contactCache = null;
    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.cssSelector("[name=entry]"));
        for (WebElement element : elements) {
            String name = element.findElement(By.xpath(".//td[3]")).getText();
            String lastname = element.findElement(By.xpath(".//td[2]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            contactCache.add(new ContactData().withId(id).withName(name).withSurname(lastname));
        }
        return new Contacts(contactCache);
    }
}