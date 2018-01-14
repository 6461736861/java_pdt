package pdt.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pdt.addressbook.models.ContactData;
import pdt.addressbook.models.GroupData;

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

//    public void fillContactBirthDate() {
//        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[17]")).isSelected()) {
//            click(By.xpath("//div[@id='content']/form/select[1]//option[17]"));
//        }
//        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[3]")).isSelected()) {
//            click(By.xpath("//div[@id='content']/form/select[2]//option[3]"));
//        }
//        click(By.name("byear"));
//        wd.findElement(By.name("byear")).clear();
//        wd.findElement(By.name("byear")).sendKeys("1990");
//        click(By.xpath("//div[@id='content']/form/input[21]"));
//    }

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
    }


    public void saveChanges() {
        click(By.name("update"));
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        click(By.xpath("//input[@value='Delete']"));
        submit();
    }

    public void save() {
        click(By.name("submit"));
    }

    public void create(ContactData contact) {
        this.initCreateContact();
        this.fill(contact);
        this.save();

    }

    public boolean isAnyContactExists() {
        return !wd.findElement(By.id("search_count")).getText().contains("0");
    }

    public List<ContactData> contactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("[name=entry]"));
        for (WebElement element : elements) {
            String name = element.findElement(By.xpath(".//td[3]")).getText();
            String lastname = element.findElement(By.xpath(".//td[2]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            contacts.add(new ContactData().withId(id).withName(name).withSurname(lastname));
        }
        return contacts;
    }

    public Set<ContactData> all() {
        Set<ContactData> contacts = new HashSet<ContactData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("[name=entry]"));
        for (WebElement element : elements) {
            String name = element.findElement(By.xpath(".//td[3]")).getText();
            String lastname = element.findElement(By.xpath(".//td[2]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            contacts.add(new ContactData().withId(id).withName(name).withSurname(lastname));
        }
        return contacts;
    }
}