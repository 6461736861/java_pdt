package pdt.addressbook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pdt.addressbook.models.ContactData;

import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModitication() {
        Set<ContactData> before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withName("modified!!!!!").withSurname("surname");
        app.contact().modify(contact);
        WebDriverWait webDriverWait = new WebDriverWait(app.wd, 5);
        new WebDriverWait(app.wd, 5).until(ExpectedConditions.textToBe(By.className("msgbox"), "Address book updated\n" + "return to home page"));

        webDriverWait.withMessage("User is not redirected to the homepage");
        webDriverWait.until(ExpectedConditions.urlContains("index.php"));
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(before.size(), after.size());
        before.remove(modifiedContact);
        before.add(contact);
        Assert.assertEquals(before, after);
    }

    @BeforeMethod
    public void createContactIfDoesNotExist() {
        if (!app.contact().isAnyContactExists()) {
            ContactData contact = new ContactData().withName("new customer").withSurname("new surname");//.withSurname("contact2");
            app.contact().create(contact);
        }
    }

}
